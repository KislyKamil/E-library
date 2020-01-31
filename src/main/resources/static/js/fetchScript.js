


$(document).ready(function () {

    $('#1')
        .addClass("page-item active");

});

$("li." + "page-item").click((event) => {

    let pageId = $(event.target).text();

    event.preventDefault();

    if ($("li").hasClass("page-item active") === true) {

        $("li")
            .removeClass("page-item active")
            .addClass("page-item");
    };



    console.log($('li#' + pageId));
    console.log(pageId);
    $('li#' + pageId)
        .removeClass("page-item")
        .addClass("page-item active");

});

function openPage(url) {


    fetch(url)
        .then(function (response) {
            return response.json();
        })
        .then(function (jsonResponse) {

            let tbody = document.getElementById("tbody");
            let obj = jsonResponse;


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


/*

    $(".search-icon").click(() => {

        const query = $(".search-box").val();


        if(query === ""){
            console.log("You have to put something to search!")
            console.log(query)

        }else if(query != ""){

            console.log("Ok!");

            fetch("/search", {
                method: "POST",
                headers: {
                    'Content-Type': 'text/json'

                },
                body: JSON.stringify(query)

            }).then((response) => {
                return response.json();

            }).then((response) => {

                console.log(response);

            })
        }
    })


 */
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

            console.log(response);

        })
    }
})

