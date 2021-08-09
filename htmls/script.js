$(document).ready(function() {
    fetchCustomers();
    drop();
})

function fetchCustomers(){
var API_URL = "http://127.0.0.1:8000/";
const urlParams = new URLSearchParams(window.location.search);
const myParam = urlParams.get('id');
$.ajax({
        url: API_URL + "user/"+ myParam +"/resource.",
            type: 'GET',
            async: true,
            dataType: 'json',
            success: resource,
            error: function(){
                console.log("error")
            }
})
}         


function trade(){
    const urlParams = new URLSearchParams(window.location.search);
    const myParam = urlParams.get('id');
    var API_URL = "http://127.0.0.1:8000/user/"+myParam+"/"+$("#hidden").text()+".";
    console.log(JSON.stringify({
        resourceSrc: $("#dropdownMenuLink").text(),
        resourceDst: $("#dropdownMenuLink1").text(),
        amount: $("#dropdownMenuLinkNumber").text()
    }),)
    $.ajax({
        url: API_URL,
        type: 'PUT',
        async: true,
        contentType: 'application/json',
        data: JSON.stringify({
            resourceSrc: $("#dropdownMenuLink").text(),
            resourceDst: $("#dropdownMenuLink1").text(),
            amount: $("#dropdownMenuLinkNumber").text()
        }),
        success: location.reload(),
        error: function(){
            alert('error');
        }
    })
}



function resource(element){
    $("#Water").text(element[0].quantity).toString();
    $("#Fuel").text(element[1].quantity).toString();
    $("#Supplies").text(element[2].quantity).toString();
    $("#Weapons").text(element[3].quantity).toString();
}

function drop(){
    $("#submit-button").click(function(){
        trade();
    })
    $("#DropWater").click(function(){
       $("#dropdownMenuLink").text("Water")
    })
    $("#DropFuel").click(function(){
        $("#dropdownMenuLink").text("Gas")
     })
     $("#DropSupplies").click(function(){
        $("#dropdownMenuLink").text("Supplies")
     })
     $("#DropWeapons").click(function(){
        $("#dropdownMenuLink").text("Weapons")
     })
     $("#DropWater1").click(function(){
        $("#dropdownMenuLink1").text("Water")
     })
     $("#DropFuel1").click(function(){
         $("#dropdownMenuLink1").text("Gas")
      })
      $("#DropSupplies1").click(function(){
         $("#dropdownMenuLink1").text("Supplies")
      })
      $("#DropWeapons1").click(function(){
         $("#dropdownMenuLink1").text("Weapons")
      })
      //Quantity buttons
      $("#One").click(function(){
        $("#dropdownMenuLinkNumber").text(1)
     })
     $("#Three").click(function(){
         $("#dropdownMenuLinkNumber").text(3)
      })
      $("#Five").click(function(){
         $("#dropdownMenuLinkNumber").text(5)
      })

      //Wanderers 
      $("#uwegfy").click(function(event){
          console.log(event);
         $("#User").text("Duncan McOkiner")
         $("#hidden").text("uwegfy")
      })
      $("#dienf").click(function(){
         $("#User").text("Ben Dover")
         $("#hidden").text("dienf")
      })
      $("#cjeba").click(function(){
        $("#User").text("Hiro Kumata")
        $("#hidden").text("cjeba")
     })
 

}

