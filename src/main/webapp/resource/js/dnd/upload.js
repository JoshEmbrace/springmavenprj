window.addEventListener("load", function () {
    var section = document.querySelector("#upload");
    var dropZone = section.querySelector(".drop-zone");
    var percentSpan = section.querySelector(".percent");
    var progressBar = section.querySelector(".progress-b");
    /*
    //drop zone에서 사용되는 이벤트
    dragenter : 드래그된 리소스가 드랍존에 들어올 때 
    dragleave : 드랍존에 들어왔던 드래그가 영역 밖으로 나갈 때
    dregover : 드랍존에서 드래그 상태로 이동 중일 때
    drop : 드랍존에 드랍할 때
    */
    dropZone.addEventListener("dragenter", function (e) {
        e.preventDefault();

        /*
        for(var key in e.dataTransfer)
        console.log(key);
        */
        if (e.dataTransfer.types[0] == "Files") {
            dropZone.classList.remove("invalide");
            dropZone.classList.add("valide");
        }
        else {
            dropZone.classList.remove("valide");
            dropZone.classList.add("invalide");
        }
    });
    dropZone.addEventListener("dragleave", function (e) {
        e.preventDefault();
        //console.log("나갔니?");
        dropZone.classList.remove("invalide");
        dropZone.classList.remove("valide");
    });

    dropZone.addEventListener("dragover", function (e) {
        e.preventDefault();
        console.log("위에 있니?");
    });

    dropZone.addEventListener("drop", function (e) {
        e.preventDefault(); // 이 부분이 없으면 파일을 브라우저 실행해버립니다.
        console.log("드랍");
        dropZone.classList.remove("invalide");
        dropZone.classList.remove("valide");


        var files = e.dataTransfer.files;
        var size = files.length;

        if (size > 1) {
            alert("파일은 하나씩만 업로드 할 수 있습니다.");
            return;
        }

        var file = files[0];
        console.log(file.type); //파일종류

        var regex = new RegExp("image/(jpeg|png|gif)");
        if (!file.type.match(regex)) {
            alert("유효한 파일 형식이 아닙니다!");
            return;
        }

        //        if(file.size > 1024*1024){
        //            alert("1메가 이상의 파일은 업로드 할 수 없습니다.")
        //            return;
        //        }


        //id=newlec&pwd=111 -> only String
        var formData = new FormData();
        formData.append("file", file);

        var request = new XMLHttpRequest();
        request.addEventListener("load", function () {
            if(request.responseText == "okay"){
                //목록을 새로 요청하기
                var req = new XMLHttpRequest();
                req.addEventListener("load", function(e){
                    alert(e.responseText);
                });
                req.open("GET","../../../file-list");
                req.send();
            }
        });
        request.upload.addEventListener("progress", function (e) {
            //loaded, total
            console.log(Math.round(e.loaded * 100 / e.total));

            if (e.lengthComputable) {
                var degree = Math.round(e.loaded * 100 / e.total);
                percentSpan.innerText = degree;
                progressBar.style.width = degree+"%";
            };
            
        });


        request.open("post", "/javaprj/upload", true); //요청하려는 것. true false 지정안하면 true 비동기로
        request.send(formData); //동기형으로 하면 여기서 멈춤현상

    });


    var fileButton = dropZone.querySelector("input[type=file]");
    var trigButton = dropZone.querySelector(".file-selector");
    trigButton.onclick = function (e) {

        var event = new MouseEvent(
            "click",
            {
                view: window,
                bubbles: true,
                cancelable: true
            }
        );

        fileButton.dispatchEvent(event);

    }

});


