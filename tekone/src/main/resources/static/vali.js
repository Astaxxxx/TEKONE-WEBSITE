
  function validateForm() {
    var name = document.forms["contactForm"]["name"].value;
    var email = document.forms["contactForm"]["email"].value;
    var phone = document.forms["contactForm"]["phone"].value;
    var message = document.forms["contactForm"]["message"].value;
    
    if (name == "") {
      alert("Name must be filled out");
      return false;
    }


    if (!/^[a-zA-Z]+$/.test(name)) {
        alert("Name can only contain letters");
        return false;
      }


    
    if (email == "") {
      alert("Email must be filled out");
      return false;
    }

    if (!/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)) {
        alert("Invalid email address");
        return false;
      }



    
    if (phone == "") {
      alert("Phone number must be filled out");
      return false;
    }

    if (!/^\d{0,11}$/.test(phone)) {
        alert("Phone number can only contain up to 11 digits");
        return false;
      }


    
    if (message == "") {
      alert("Message must be filled out");
      return false;
    }
    alert("Thank you for submitting the form. Your information has been received.");
    return false;
}


   

  
