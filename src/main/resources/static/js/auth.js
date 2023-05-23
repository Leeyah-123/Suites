window.onload = () => {
    if (!localStorage.getItem('access_token')) {
        window.open('/login', '_self');
    }
}

function logout() {
    if(confirm("Are you sure you want to logout?")) {
        localStorage.removeItem("access_token");
        localStorage.removeItem("refresh_token");

        window.open('/login?logout=true', '_self');
    }
}

$.ajaxSetup({
    beforeSend: function(xhr) {
        xhr.setRequestHeader('Authorization', `Bearer ${localStorage.getItem('access_token')}`);
    }
});

function makeProfileCall() {
   return $.ajax({
        type : "get",
        dataType: "json",
        url : 'http://localhost:8080/api/user/profile'
    })
}

$(document).ajaxError(function(event,xhr,options){
    if (xhr.status === 401 || xhr.status === 403) {
        window.open('/login', '_self');
    }
});