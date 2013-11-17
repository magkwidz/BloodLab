$(function() {
    $("#pesel-input").keypress(function() {
        var pesel = $(this).val();
        $.get("rest/people/" + pesel, function(bloodResults) {
            var stringifiedBloodResults =  bloodResults;
            var htmlbloodresult = "<h4> Hemoglobina = " + stringifiedBloodResults + " g/dl </h4>";
            var recipient = "<p>Wyniki morfologii krwi dla osoby o numerze PESEL " + pesel + "</p>";
            $("#blood-recipient").html(recipient);
            $("#blood-results").html(htmlbloodresult);
            
        });
    });
});