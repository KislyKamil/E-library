function loginUser(url) {
    let xhttp = new XMLHttpRequest();
    let login = document.getElementById("login");
    let password = document.getElementById("password");

    document.write(this.responseText);


    xhttp.open("POST", url, true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send();
};