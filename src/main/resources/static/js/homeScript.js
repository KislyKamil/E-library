$('.search-button').click(function () {
    $(this).parent().toggleClass('open');


    if($(".search open")){
        $(this).off('click');
    }
});


/*
function setPage(id) {
    let page = document.getElementById(id);

    let previousId = 1;


    let previous = String(previousId);


    let previousPage = document.getElementById(previous);

    page.setAttribute("class", "page-item active");
}
*/
