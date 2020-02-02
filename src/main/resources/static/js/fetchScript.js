


$(document).ready(function () {

    $('.page-item[id="1"]')
        .addClass("page-item active");

})

$('li.page-item').click(function() {
    $(this).addClass('active').siblings().removeClass('active');
});


function openPage(url) {


    fetch(url)
        .then(function (response) {
            return response.json();
        })
        .then(function (jsonResponse) {
            newPage(jsonResponse);

        });
}


$(".search-icon").click(() => {

    const query = $(".search-box").val();


    if(!query){
        console.log("You have to put something to search!")


    }else if(query != ""){

        console.log("Ok!");

        fetch("/search?query=" + query

        ).then((response) => {
            return response.json();

        }).then((response) => {

            newPage(response);
            $(".pagination").html(" ")

        })
    }
})

$('#searchUser').click(() =>{

    const query = $(".findBox").val();

    fetch("/adminPanel/find?query=" + query

    ).then((response) => {
        return response.json();

    }).then((response) => {
        //console.log(response)
        showUser(response)

    })

})

function showUser(data) {

    let body = document.getElementById("userBox");
    let obj = data;

    body.innerHTML = "";
    let div1 = "<div class='userLogin'>" + obj[0].login + "</div></br>";
    let div2 = "<div class='userLogin'>" + obj[0].email + "</div></br>";


    body.innerHTML = div1 + div2;

}

function newPage(response) {
    let tbody = document.getElementById("tbody");
    let obj = response;

    tbody.innerHTML = "";

    for (var i = 0; i < obj.length; i++) {
        let tr = "<tr id =" + obj[i].bookId + ">";

        tr += "<td>" + obj[i].name.toString() + "</td>" + "<td>" + obj[i].author.toString() + "</td><td><button class='btn btn-primary' id=" + obj[i].bookId + " onclick='add()'>reserve</button></td></tr>";

        tbody.innerHTML += tr;
    }
}