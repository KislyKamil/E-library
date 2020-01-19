/*
function openPage(url) {

    let xhttp = new XMLHttpRequest();

    document.getElementById("bookList").innerHTML = xhttp.responseText;


    xhttp.open("POST", url, true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send(url);
    console.log(typeof (xhttp.responseText));
    console.log(xhttp.responseText);
};
*/


function openPage(url) {

    fetch(url)
        .then(function (response) {
            return response.json();
        })
        .then(function (jsonResponse) {

            let tbody = document.getElementById("tbody");
            let obj = jsonResponse;

            tbody.innerHTML = "";

            for (var i = 0; i < obj.length; i++) {
                let tr = "<tr id =" + obj[i].bookId + ">";

                tr += "<td>" + obj[i].name.toString() + "</td>" + "<td>" + obj[i].author.toString() + "</td></tr>";

                tbody.innerHTML += tr;
            }
            ;

            console.log(tbody);
            console.log(typeof (jsonResponse));
            console.log(jsonResponse);
            console.log(jsonResponse[2].author);
            console.log(obj.length);
        });
}
