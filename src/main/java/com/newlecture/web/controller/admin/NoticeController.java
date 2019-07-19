package com.newlecture.web.controller.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

@Controller("adminNoticeController")
@RequestMapping("/admin/notice/")
public class NoticeController {
	
	/*
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	*/
	
	
	//@Qualifier("mybatisNoticeDao") 모호한경우
	@Autowired
	private NoticeDao noticeDao;
	
	
	@RequestMapping("list")
	public String list(Model model) throws ClassNotFoundException, SQLException {
		//1.세션 도구를 생성해서 SqlSession sqlSession = ?;
		//세션객체를 통해서 매퍼를 얻어서 원하는 메소드를 호출한다.
		
		//2.세션도구를 얻는 작업을 설정에서 템플릿 여기서는 그냥 그 세션도구를 얻어서 호
		//List<NoticeView> list= sqlSession.getMapper(NoticeDao.class).getList();
		
		//NoticeDao noticeDao = sqlSession.getMapper(NoticeDao.class);
		List<NoticeView> list = noticeDao.getList();
		model.addAttribute("list", list);
		return "admin/notice/list";
	}
	
	
	/*
	@Autowired
	private NoticeDao noticeDao;
	
	@RequestMapping("list")
	public String list(Model model, @RequestParam(name = "p", defaultValue = "1") Integer page)
			throws ClassNotFoundException, SQLException {
		model.addAttribute("list", noticeDao.getList(page));
		return "admin/notice/list";
	}
	*/

	// ## 4.x 이후 버전 방식 ##
	// GET 요청
	@GetMapping("reg")
	public String reg() {

		return "admin/notice/reg";
	}

	// POST 요청
	@PostMapping("reg")
	public String reg(Notice notice
			, String category
			, MultipartFile file
			, HttpServletRequest request) throws IOException, ClassNotFoundException, SQLException {
		// public String reg(Notice notice) {
		// public String reg(String category, String title, String file, String content)
		// {

		System.out.println(category);
		System.out.println(notice.getTitle());
		System.out.println(file.getOriginalFilename());
		System.out.println(notice.getContent());

		// 1. 업로드 경로를 얻기
		String urlPath = "/upload";
		String path = request.getServletContext().getRealPath(urlPath);

		System.out.println(path);

		// 2. 업로드된 파일명 얻기
		String fileName = file.getOriginalFilename();//filePart.getSubmittedFileName();

		// 3. 경로 구분자 넣기
		String filePath = path + File.separator + fileName; // d:\aa + "bb.jpg" -> d:\aabb.jpg

		System.out.println(filePath);

		// 4. 경로가 없다는 오류 문제
		File pathFile = new File(path);
		if (!pathFile.exists()) // 존재하지 않으면
			pathFile.mkdirs();// 생성해주세요.

		// 5. 동일한 파일명에 경로에 이미 존재하는 문제 : 이름 정책
		// aa.jpg -> aa.jpg1 ==> aa1.jpg
		// aa1.jpg -> aa(1).jpg
		/*
		 * File ? = new File(?);
		 * 
		 * if(? 존재한다면) { 꼬리(확장자)를 잘라낸 이름을 얻고 그 마지막에 소괄호()가 있는지 확인하고 있으면 번호를 알아내고 1증가된 값을
		 * 얻어서.. fileName = ?; }
		 */

		File sameFile = new File(filePath);
		System.out.println(sameFile);
		if (sameFile.exists()) {

			int n = fileName.lastIndexOf("."); // fileName=hello.jpg n =?, name= , suffix,
			String name = fileName.substring(0, n); //
			String suffix = fileName.substring(n);

			// name.endsWith(")");
			// int parenS = name.lastIndexOf("(");
			// int parenE = name.lastIndexOf(")");

			// String indexC = name.substring(parenS+1, parenE);

			// int indexN = Integer.parseInt(indexC);

			// if (parenS == -1)
			fileName = name + "(" + 1 + ")" + suffix;
			// else {
			// indexN++;
			// fileName = fileName.substring(0, parenS+1)+ indexN +")"+ suffix;
			// }
		}

		InputStream fis = file.getInputStream();//filePart.getInputStream();
		OutputStream fos = new FileOutputStream(filePath);

		byte[] buf = new byte[1024];
		int size = 0;
		while ((size = fis.read(buf)) != -1)
			fos.write(buf, 0, size);

		fis.close();
		fos.close();
		
		
		notice.setWriterId("newlec");
		noticeDao.insert(notice);
		
		
		

		// 리디렉션 방식 : list 페이지로
		return "redirect:list";

		// 포워딩 방식 : return "admin/notice/reg";
	}
	/*
	 * // GET 요청
	 * 
	 * @RequestMapping(value="reg", method=RequestMethod.GET) public String reg() {
	 * 
	 * return "admin/notice/reg"; }
	 * 
	 * // POST 요청
	 * 
	 * @RequestMapping(value="reg", method=RequestMethod.POST) public String
	 * reg(String title) {
	 * 
	 * //리디렉션 방식 : list 페이지로 return "redirect:list";
	 * 
	 * //포워딩 방식 : return "admin/notice/reg"; }
	 */

	@GetMapping("detail")
	public String detail(Integer id, Model model) {

		Notice notice = noticeDao.get(id);
		
		model.addAttribute(notice);

		return "admin/notice/detail";
	}

	@GetMapping("edit")
	public String edit(Model model, HttpServletRequest request) {

		int id = Integer.parseInt(request.getParameter("id"));
		model.addAttribute("notice", noticeDao.get(id));

		return "admin/notice/edit";
	}

	@PostMapping("edit")
	public String edit(HttpServletRequest request) throws ClassNotFoundException, SQLException {

		Integer id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		Notice notice = new Notice();
		notice.setId(id);
		notice.setTitle(title);
		notice.setContent(content);

		noticeDao.update(notice);

		return "redirect:detail?id=" + id;
	}

}
