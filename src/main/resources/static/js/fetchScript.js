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

$(document).ready(function () {

    $('#1')
        .addClass("page-item active");

});

$(document).click((event) => {

    let pageId = $(event.target).text();


    if ($("li").hasClass("page-item active") === true) {

        $("li")
            .removeClass("page-item active")
            .addClass("page-item");
    }

    $('#' + pageId)
        .addClass("page-item active")

})

function openPage(url) {


    fetch(url)
        .then(function (response) {
            return response.json();
        })
        .then(function (jsonResponse) {

            let tbody = document.getElementById("tbody");
            let obj = jsonResponse;
            let pageId = 1;

            tbody.innerHTML = "";

            /* if(obj[0].bookId !== 1){

                 pageId =
             }

             */


            for (var i = 0; i < obj.length; i++) {
                let tr = "<tr id =" + obj[i].bookId + ">";

                tr += "<td>" + obj[i].name.toString() + "</td>" + "<td>" + obj[i].author.toString() + "</td></tr>";

                tbody.innerHTML += tr;
            }
            ;

            //Testing

            /*

             console.log(tbody);
             console.log(typeof (jsonResponse));
             console.log(jsonResponse);
             console.log(jsonResponse[1].author);
             console.log(obj.length);

             */
        });
}
