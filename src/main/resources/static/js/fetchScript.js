


$(document).ready(function () {

    $('#1')
        .addClass("page-item active");

});

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

function newPage(response) {
    let tbody = document.getElementById("tbody");
    let obj = response;

    tbody.innerHTML = "";

    for (var i = 0; i < obj.length; i++) {
        let tr = "<tr id =" + obj[i].bookId + ">";

        tr += "<td>" + obj[i].name.toString() + "</td>" + "<td>" + obj[i].author.toString() + "</td></tr>";

        tbody.innerHTML += tr;
    }
}