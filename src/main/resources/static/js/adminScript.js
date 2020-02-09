



$('.addBook').click(() => {

    let input1 = $('.name').val()
    let input2 = $('.author').val()

    if(input1 !== null && input2 !== null) {

        fetch("/adminPanel/addBook?name=" + input1 + "&author="+ input2
        ).then((response) => {
        alert("Book added successfully")

        })

        input1.val("")
        input2.val("")
    }
})
