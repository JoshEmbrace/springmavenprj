// $(function(){
//     var section = $("#upload");
//     var dropzone = section.find(".box");


//     dropzone.function(){
//         console.log("들어옴");
//     }

//     /*
//     drop zone 에서 사용되는 이벤트
    
//     dragenter : 드래그된 리소스가 drop zone에 들어올 때
//     dragleave : drop zone에 들어왔던 드래그가 영역 밖으로 나갈 때
//     dragover : drop zone에서 드래그 상태로 이동 중일 때
//     drop : drop zone에서 드랍할 때

//     */
// });


window.addEventListener("load",function(){
    var section = this.document.querySelector("#upload");
    var dropzone = section.querySelector(".drop-zone");
    var percentSpan = section.querySelector(".percent");
    var progress = dropzone.querySelector(".progress");


    var fileButton = dropzone.querySelector("input[type=file]");    
    var trigButton = dropzone.querySelector("div");
    
    trigButton.onclick = function(e){        
        
        var event = new MouseEvent(
            "click",
            {
                view:window,
                bubbles:true,
                cancelable:true
            }
        );
        
        fileButton.dispatchEvent(event);
    };


    dropzone.addEventListener("dragenter",function(e){
        e.preventDefault();
        console.log("들어옴?");

        // for(var key in e.dataTransfer.types[0])
        //     console.log(e.dataTransfer.types[0]);

            //console.log(e.dataTransfer.types[0].getData());

        // var data = e.dataTransfer;

        // console.log(data.items.length);

        // for(var i=0;i<e.dataTransfer.items.length;i++)
        //     alert(e.dataTransfer.items[i]);


        //for(var i=0;i<data.items.l)

            // for(var i=0 ; i< e.dataTransfer.types.length;i++)
            //     console.log(e.dataTransfer.types[i]);
        
        if(e.dataTransfer.types[0] == 'Files'){
            dropzone.classList.remove("invalide");
            dropzone.classList.add("valide");
            //console.log("드랍하세요");
        }
        else{
            dropzone.classList.remove("valide");
            dropzone.classList.add("invalide");
            //console.log("유효한 파일이 아닙니다.");
        }
    });

    dropzone.addEventListener("dragleave",function(e){
        dropzone.classList.remove("invalide");
        dropzone.classList.remove("valide");
        e.preventDefault();
        console.log("나감?");
    });

    dropzone.addEventListener("dragover",function(e){
        e.preventDefault();
        console.log("위?");
    });

    dropzone.addEventListener("drop",function(e){
        dropzone.classList.remove("invalide");
        dropzone.classList.remove("valide");
        e.preventDefault();
        console.log("떨굼?");


        var files = e.dataTransfer.files;
        var size = files.length;

        if(size>1){
            alert("파일은 하나씩만 업로드 가능");
            return;
        }

        var file = files[0];
        console.log(file.type);
        var regex = new RegExp("image/(jpeg|png|gif)");
        //if(!file.type.match(/image\/(jpeg|gif|png)/)){
        if(!file.type.match(regex)) {
            alert("유효한 파일 형식이 아님.");
            return;
        }

        // if(file.size > 10*1024*1024 ){
        //     alert("10메가 이상의 파일은 업로드 불가능");
        //     return;
        // }

        
        var formData = new FormData();
        formData.append("file",file);
        
        var request = new XMLHttpRequest();
        request.addEventListener("load",function(e){
           if(request.responseText == "ok"){

                //목록을 새로 출력하기
                var req = new XMLHttpRequest();
                req.addEventListener("load",function(e1){
                   alert(req.responseText);
                   console.log(req.responseText);
                });
                req.open("GET","../../../file-list");
                req.send();
            }
           else
              alert("업로드 실패");
           //alert(request.responseText);
        });

        request.upload.addEventListener("progress",function(e){
            // loaded, total
            console.log(Math.round(e.loaded * 100 /e.total));
            if(e.lengthComputable){
                var degree = Math.round(e.loaded * 100 /e.total);
                percentSpan.innerText = degree;
                progress.style.width= degree+"%";
            }
            // else
            //     progress.innerText = "전송크기를 계산 할 수 없습니다.";
        });
        request.open("POST","/javaprj/upload",true);
        request.send(formData);
        /*
         load
         error
         abort
         uploadProgress
         */
        

        
        

    });
});
