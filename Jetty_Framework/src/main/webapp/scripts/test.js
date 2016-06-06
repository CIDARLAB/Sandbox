function testJetty() {
    $.ajax({
        url: "SampleJetty",
        type: "POST",
        data: {
            "rank": document.getElementById("rank").value
        },
        success: function (response) {
            result = JSON.parse(response);
            alert("New rank is  (Rank + 1)::" + result.rank);
        },
        error: function () {
            alert("ERROR!!");
        }
    });
}
