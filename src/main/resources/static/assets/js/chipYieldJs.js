function refurbishIndex(filterData){
    alert(filterData);
    var jsonObj = {"filterData":filterData};
    /*
        Jquery默认Content-Type为application/x-www-form-urlencoded类型
     */
    $.ajax({
        type: 'POST',
        url: "ajaxTest",
        dataType: "json",
        data: JSON.stringify(jsonObj),
        contentType : "application/json",
        success: function(data) {
            console.log(data)
        },
        error: function() {
            console.log("fucking error")
        }
    });
}