package com.newlecture.web.controller;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.newlecture.web.dao.FileDao;
import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.File;

@Controller
@RequestMapping("/")
public class RootController {

	@Autowired
	private NoticeDao noticeDao;

	/*
	 * @RequestMapping("index") //@ResponseBody �̰� ���̸� ȭ�鿡 index��� ���ڰ� ��µ� public
	 * String index(Model model) { model.addAttribute("x", "�����ع��ȴ�"); return
	 * "index"; //-> /WEB-INF/view + index + .jsp }
	 */

	/*
	 * @RequestMapping("index") public void index(HttpServletResponse response)
	 * throws IOException { PrintWriter out = response.getWriter();
	 * out.println("Welcome Home!!"); }
	 */
	@Autowired
	private FileDao fileDao;
	
	@GetMapping("file-list")
	@ResponseBody
	public String fileList() {
		String urlPath = "/upload";
		String realPath = "";
		
		List<File> list = fileDao.getList(realPath);
		
		return "";
	}
	
	@PostMapping("upload")
	@ResponseBody
	public String upload(MultipartFile file, HttpServletRequest request) throws IOException {

		// 1. ���ε� ��θ� ���
		String urlPath = "/upload";
		String path = request.getServletContext().getRealPath(urlPath);

		System.out.println(path);

		// 2. ���ε�� ���ϸ� ���
		String fileName = file.getOriginalFilename();// filePart.getSubmittedFileName();

		// 3. ��� ������ �ֱ�
		String filePath = path + java.io.File.separator + fileName; // d:\aa + "bb.jpg" -> d:\aabb.jpg

		System.out.println(filePath);

		// 4. ��ΰ� ���ٴ� ���� ����
		java.io.File pathFile = new java.io.File(path);
		if (!pathFile.exists()) // �������� ������
			pathFile.mkdirs();// �������ּ���.

		// 5. ������ ���ϸ��� ��ο� �̹� �����ϴ� ���� : �̸� ��å
		// aa.jpg -> aa.jpg1 ==> aa1.jpg
		// aa1.jpg -> aa(1).jpg
		/*
		 * File ? = new File(?);
		 * 
		 * if(? �����Ѵٸ�) { ����(Ȯ����)�� �߶� �̸��� ��� �� �������� �Ұ�ȣ()�� �ִ��� Ȯ���ϰ� ������ ��ȣ�� �˾Ƴ��� 1������ ����
		 * ��.. fileName = ?; }
		 */

		java.io.File sameFile = new java.io.File(filePath);
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

		InputStream fis = file.getInputStream();// filePart.getInputStream();
		OutputStream fos = new FileOutputStream(filePath);

		byte[] buf = new byte[1024];
		int size = 0;
		while ((size = fis.read(buf)) != -1)
			fos.write(buf, 0, size);

		fis.close();
		fos.close();

		
		
		return "OK";
	}

	@RequestMapping("index")
	@ResponseBody
	public String index() {

		return "ȯ���մϴ�.";
	}
	/*
	 * @RequestMapping("index")
	 * 
	 * @ResponseBody public String index() {
	 * 
	 * System.out.println("�ε�����û�� �־���"); return "Welcome Home!"; }
	 */

	@RequestMapping("hello")
	public void �ƹ��Լ���() {
		System.out.println("��ο�û�� �־���");
	}

}