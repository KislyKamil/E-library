function openPage(url) {
    let xhttp = new XMLHttpRequest();
    //let pageId = url + '/*[[${i}]]*/';
    document.getElementById("bookList").innerHTML = this.responseText;


    xhttp.open("POST", url, true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send(url);
};