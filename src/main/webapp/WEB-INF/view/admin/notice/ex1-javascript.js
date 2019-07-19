//--ex7 -- 공지사항 조작하기  -------------------------------------------------------
window.addEventListener("load",function(){
    var section = this.document.querySelector("#ex7");
    var btn= section.querySelector(".btn-load");   
    var noticeTbody = section.querySelector(".notice tbody");

    //var btn1=section.querySelector(".btn1");

    var btn123 = section.querySelectorAll("td");

    for(var a in btn123){
        btn123[a].onclick = function(){
            alert(btn123[a].nodeValue);
        };
    }
    console.log(btn123.length);
    //var rowIndex=0;

    var notices = [
        {
            id:6,
            title:"뉴렉쌤 9월 초 국기과정 모집 안내",
            writerId:"newlec",
            regDate:"2019-06-11",
            hit:30
        },
        {
            id:5,
            title:"뉴렉처 강의 수강 방식 안내",
            writerId:"newlec",
            regDate:"2019-05-24",
            hit:120
        },
        {
            id:4,
            title:"자바 구조적인 프로그래밍 강의 예제 파일",
            writerId:"newlec",
            regDate:"2019-04-24",
            hit:231
        },
    ];

    

    // btn1.onclick = function(){
    //     var request = new XMLHttpRequest();
    //     request.open("GET","/notice/list-ajax?p=1",false);
    //     request.send();

    //     var json = JSON.parse(request.responseText);
        
    //     json = json.concat(notices);
    //     //console.log(json[0].title);
        
    //     //alert(request.responseText);
    //     json.sort(function(a,b) {
    //         if(btn1num==0)
    //             return parseFloat(a.id) - parseFloat(b.id);  
    //         else
    //             return parseFloat(b.id) - parseFloat(a.id);  
    //     });

        
    //     // 방법 2 : 템플릿 문자열(문자열안에 값을 끼워넣는 방법)을 이용한 DOM 조작 #3
    //     var keys = Object.keys(json[0]);
    //     // var keys = Object.keys(notices[0]);
    //     var html = [];

    //     for(var i=0;i<json.length;i++){
    //         html.push("<tr>");
    //         for(var j=0;j<keys.length;j++){
    //             html.push("<td>"+json[i][keys[j]]+"</td>");
    //         }
    //         html.push("</tr>");
            
    //     }
    //     noticeTbody.innerHTML = html.join("");
    // };

    //var html=""; // 방법 2 : 템플릿 문자열을 이용한 DOM 조작 #2

    btn.onclick = function(){
        
        

        // 데이터 요청하기
        var request = new XMLHttpRequest();
        request.open("GET","/notice/list-ajax?p=1",false);
        request.send();

        var json = JSON.parse(request.responseText);
        
        json = json.concat(notices);
        //console.log(json[0].title);
        
        //alert(request.responseText);
        // json.sort(function(a,b) {

        //     return parseFloat(a.id) - parseFloat(b.id);
        
        // });

        
        // 방법 2 : 템플릿 문자열(문자열안에 값을 끼워넣는 방법)을 이용한 DOM 조작 #3
        var keys = Object.keys(json[0]);
        // var keys = Object.keys(notices[0]);
        var html = [];

        for(var i=0;i<json.length;i++){
            html.push("<tr>");
            for(var j=0;j<keys.length;j++){
                html.push("<td>"+json[i][keys[j]]+"</td>");
            }
            html.push("</tr>");
            
        }
        noticeTbody.innerHTML = html.join("");
        //alert(html.join(""));
        
        
        // var str="";
        // for(var i=0;i<html.length;i++){
        //     str += html[i];
        // }
        // noticeTbody.innerHTML += str;


        
        // 방법 2 : 템플릿 문자열을 이용한 DOM 조작 #2
        // var keys = Object.keys(notices[0]);

        // for(var i=0;i<notices.length;i++){
        //     var tdStr = "";
        //     for(var j=0;j<keys.length;j++){
        //         tdStr += "<td>"+notices[i][keys[j]]+"</td>";
        //     }
        //     trStr = "<tr>"+tdStr+"</tr>";
        //     html += trStr;
        // }
        // noticeTbody.innerHTML = html;




        // 방법 2 : 템플릿 문자열을 이용한 DOM 조작 #1 

        // var keys = Object.keys(notices[0]);
        // for(var i=0;i<notices.length;i++){
        //     noticeTbody.innerHTML += "<tr>";
        //     var tds="";
        //     for(var j=0;j<keys.length;j++){
        //         tds += "<td>"+notices[i][keys[j]]+"</td>";
        //     }
        //     //var tr = "<tr>"+tds+"</tr>";
        //     noticeTbody.innerHTML += tds+"</tr>";
        // }






        // for(var i=0;i<notices.length;i++){
        //     noticeTbody.innerHTML += "<tr>";
        //     for(var j=0;j<5;j++)
        //         noticeTbody.innerHTML += "<td>"+notices[i][keys[j]]+"</td>";
        //     noticeTbody.innerHTML += "</tr>";

        // }

        

        // for(var i=0;i<notices.length;i++){
        //     string1 += "<tr><td>"+notices[i].id+"</td>"+
        //     "<td>"+notices[i].title+"</td>"+
        //     "<td>"+notices[i].writerId+"</td>"+
        //     "<td>"+notices[i].regDate+"</td>"+
        //     "<td>"+notices[i].hit+"</td></tr>";
        // }



        // var row = notice.insertRow(rowIndex);
        // var keys = Object.keys(notices[0]);

        // var row = noticeTbody.insertRow(rowIndex);
        // for(var i=0;i<keys.length;i++){
        //     var cel = row.insertCell(i);
        //     cel.innerHTML = notices[0][keys[i]];
        // }
        // rowIndex++;
        

        //방법 1 : 맨땅의 DOM 조작 append

        // var keys = Object.keys(notices[0]);// ["id","title","writerId","regDate","hit"]

        // console.log(keys);
        // for(var j=0;j<notices.length;j++){
        //     var tr = document.createElement("tr");
        //     for(var i=0;i<5;i++){
        //         var td = document.createElement("td");
        //         var key = keys[i];
        //         td.append(notices[j][key]);
        //         tr.append(td);
        //     }            
        //     noticeTbody.append(tr);
        // }
        
        // 방법 1 : 맨땅의 DOM 조작 appendChild
        // var keys = Object.keys(notices[0]);
        // //var keys = ["id","title","writerId","regDate","hit"];
        // console.log(keys);
        // for(var j=0;j<notices.length;j++){
        //     var tr = document.createElement("tr");
        //     for(var i=0;i<5;i++){
        //         var td = document.createElement("td");
        //         var txt = document.createTextNode(notices[j][keys[i]]);
        //         td.appendChild(txt);
        //         tr.appendChild(td);
        //     }
            
        //     noticeTbody.appendChild(tr);
        // }
        
    };
});



//--ex6 -- 노드 조작하기  -------------------------------------------------------
window.addEventListener("load",function(){
    var section = this.document.querySelector("#ex6");
    var textBtn = section.querySelector(".btn-add-text");
    var elemBtn = section.querySelector(".btn-add-element");
    var container = section.querySelector(".container");

    textBtn.onclick = function(){
        var textNode = document.createTextNode("안녕하세요");
        container.appendChild(textNode);
    };

    elemBtn.onclick = function(){
        var el = document.createElement("div");
        //el["class"] = "box"; //예약어
        el.className = "box";
        container.appendChild(el);
    };

});


//--ex5 -- 속성 다루기 예제 -------------------------------------------------------
window.addEventListener("load",function(){
    var section = this.document.querySelector("#ex5_");
    var imgselect = section.querySelector(".img-select");
    var btn = section.querySelector(".btn1");
    var input = section.querySelector(".input");
    var img = section.querySelector("img");

    btn.onclick = function(){
        img.src= imgselect.options[imgselect.selectedIndex].value;
        img.style.border = input.value;
    }
});



//--ex5 -- 속성 다루기  -------------------------------------------------------
window.addEventListener("load",function(){
    var section = this.document.querySelector("#ex5");

    var button1 = section.querySelector(".btn1");
    var button2 = section.querySelector(".btn2");
    var img = section.querySelector("img");

    button1.onclick = function(){
        img.src="https://travel.taichung.gov.tw/Utility/DisplayImage?id=16066";
    };

    var tid;

    button2.onclick = function(){

        //img.style["border-bottom"] = "3px solid red";
        img.style.borderBottom = "3px solid red";
        //var width = img.width;
        //console.log(img.width);
        //img.style.width = "200px";

        var f1 = function(){
            var width = img.width; // img.width속성은 정수형이라 parse (x) 읽기전용 조작x style속성을 써야 조작 가능
            width--;
            img.style.width = width+"px";

            if(width==200)
                window.clearInterval(tid);

            /*
            innerText는 문자열 그대로를 리턴하는 반면,
            innerHTML은 태그를 적용시켜, 즉 문자열을 html로 인식하여 리턴한다.
            */
        }
        if(tid == undefined)
            tid = window.setInterval(f1,1);

    };

});




//--ex4 -- 노드 선택 방법 4가지 -------------------------------------------------------
window.addEventListener("load",function(){
    var section = this.document.getElementById("ex4");
    
    // 방법 4
    var button = this.document.querySelector("#ex4>input");
    var ul = section.querySelector("ul");
    var lis = ul.querySelectorAll("li");
   
    // 방법 3
    // var button = section.firstChild; 모든 자식 노드들 
    // var button = section.firstElementChild; // element 자식 노드들
    // var ul = button.nextElementSibling;
    // var lis = ul.children;
    
   
   
    // 방법 2     childNodes <=> children
    //var button = section.childNodes[1]; 공백도 자식요소로 봄
    // var button = section.children[0];// element요소만 자식
    // this.console.log(button.nodeType);
    // var ul = section.children[1];
    // var lis = ul.children;


   
    // 방법 1
    // var button = section.getElementsByTagName("input")[0];
    // var ul = section.getElementsByTagName("ul")[1];
    // var lis = ul.getElementsByTagName("li");

    
    button.onclick = function(){
        console.log(lis);
        lis[3].remove();
        console.log(lis);
    };
});



//--ex3---------------------------------------------------------------
window.addEventListener("load",function(){

    var btnEx3 = document.getElementById("btn-ex3");
    var view = document.getElementById("view");
    var fwin = view.contentWindow;
    var fbtnEx3 = fwin.document.getElementById("btn-ex3");

    btnEx3.onclick = function(){
        fbtnEx3.value = "안녕하세요";
        console.log(window.location);
        fwin.location.href="http://www.newlecture.com";
    };

});


//--ex2---------------------------------------------------------------
window.addEventListener("load",function(){
    //var countBtn1 = this.document.getElementsByName("countdown-button");
    var countBtn = document.getElementById("countdown-button");
    var countSpan = document.getElementById("count-span");
    var tid;

   

    countBtn.onclick = function(){

        var f1 = function(){
            var num = parseInt(countSpan.innerText);
            if(num==0)
                window.clearInterval(tid);
            console.log(countSpan.innerText);
            countSpan.innerText = --num;
            /*
            innerText는 문자열 그대로를 리턴하는 반면,
            innerHTML은 태그를 적용시켜, 즉 문자열을 html로 인식하여 리턴한다.
            */
        }
        if(tid == undefined)
            tid = window.setInterval(f1,1000);
    }
});




//--ex1---------------------------------------------------------------
    //window.onload =	function(){
window.addEventListener("load", function(){
        var btnResult = document.getElementById("btn-result");

        btnResult.onclick = function(){
            var x_ = document.getElementById("x-input");
            var x = parseInt(x_.value);

            var y_ = document.getElementById("y-input");
            var y = parseInt(y_.value);		
            
            // var result = document.getElementById("result");
            // result.value=x+y;
            alert(x+y);

        };

    var rowIndex = 0;
    var btn = document.getElementById("btn");
    btn.onclick= function(){

        var x = parseInt(document.getElementById("x-input").value);
        var y = parseInt(document.getElementById("y-input").value);
        var sum = x+y;

        var objTable = document.getElementById('table1');
        var objRow = objTable.insertRow(rowIndex);
        var cell = objRow.insertCell(0);
        var cel2 = objRow.insertCell(1);
        var cel3 = objRow.insertCell(2);

        cell.innerHTML = x;
        cel2.innerHTML = y;
        cel3.innerHTML = sum;
        rowIndex++;
    };
});