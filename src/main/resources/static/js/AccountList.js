$(document).ready(function () {
    let url = 'localhost:8080/api/v1/manager/get-all'
    $.ajax({
        url: url,
        type: 'GET',
        dataType: 'application/json',
    }).done(function(response) {
        $('#table_id').DataTable(function (){
            data: response
                });
    });

});