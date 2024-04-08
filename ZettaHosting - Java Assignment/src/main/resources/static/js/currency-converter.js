function getAllCurrencies() {

    const dropdownFrom = document.getElementById("dropdown-from");
    const dropdownTo = document.getElementById("dropdown-to");

    const xmlRequest = new XMLHttpRequest();

    xmlRequest.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            const jsonParsed = JSON.parse(this.responseText);
            fillCurrencies(dropdownFrom, jsonParsed);
            fillCurrencies(dropdownTo, jsonParsed);

            fillButtonInfo();
        }
    };

    xmlRequest.open("GET", "/api/currencies", true);
    xmlRequest.send();
}

function fillCurrencies(dropdown, jsonParsed) {
    for (let i = 0; i < jsonParsed.length; i++) {
        const a = document.createElement("a");
        a.setAttribute("class", "dropdown-item");
        const text = document.createTextNode(jsonParsed[i].name);
        a.appendChild(text);
        a.setAttribute("value", jsonParsed[i].name);
        dropdown.appendChild(a);
    }
}

function filterFunction(input, dropdown) {
    if (input == null) {
        return
    }
    var filter, ul, li, a, i;
    input = document.getElementById(input);
    filter = input.value.toUpperCase();
    let div = document.getElementById(dropdown);
    a = div.getElementsByTagName("a");
    for (let i = 0; i < a.length; i++) {
        if (a[i].innerHTML.toUpperCase().indexOf(filter) > -1) {
            a[i].style.display = "";
        } else {
            a[i].style.display = "none";
        }
    }
}

function fillButtonInfo() {
    const listAs = document.querySelectorAll(".dropdown-menu a");
    for (let i = 0; i < listAs.length; i++) {
        var a = listAs[i];
        a.addEventListener("click", function (evt) {
            var a = evt.target;
            var button = a.parentElement.previousElementSibling;
            button.innerHTML = a.getAttribute("value");
        })
    }
}

$("#convertButton").click(function () {
    const currenciesFrom = $('#dropdownFromButton').text();
    const currenciesTo = $('#dropdownToButton').text();
    const amount = $('#amountInput').val();

    $.ajax({
        type: "POST",
        url: "/api/currencies/convert",
        data: JSON.stringify({
            "currenciesFrom": currenciesFrom,
            "currenciesTo": currenciesTo,
            "amount": amount
        }),
        contentType: "application/json",
        success: function (data) {
            console.log(data);
            const convertedAmount = data.convertedAmount;
            const timestamp = data.timestamp;
            $("#convertResult").text(`Converted Amount: ${convertedAmount.toFixed(2)}, 
            Timestamp: ${timestamp.replace('T', ' ').split('.')[0]}`);
        },
        error: function (data) {
            alert('There was a problem with converting the amount! Amount is negative.')
        }
    });

})

$("#exchangeRate").click(function () {
    const currenciesFrom = $('#dropdownFromButton').text();
    const currenciesTo = $('#dropdownToButton').text();


    $.ajax({
        type: "GET",
        url: "/api/currencies/exchangeRate",
        data: {
            "currenciesFrom": currenciesFrom,
            "currenciesTo": currenciesTo,

        },
        contentType: "application/json",
        success: function (data) {
            console.log(data);
            const exchangeRate = data.exchangeRate;

            $("#exchangeRateResult").text("Exchange Rate:" + data.toFixed(2));
        },
        error: function (data) {
            alert('There was a problem with getting the exchange Rate!')
        }
    });
})

