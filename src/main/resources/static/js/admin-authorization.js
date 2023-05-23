$.ajaxSetup({
    beforeSend: function(xhr) {
        xhr.setRequestHeader('Authorization', `Bearer ${localStorage.getItem('access_token')}`);
    }
});

$.ajax({
    type: "get",
    dataType: "json",
    url: 'http://localhost:8080/api/user/profile',
    success: function (userDetails) {
        let isAdmin = false;

        for (const roleIndex in userDetails.roles) {
            const role = userDetails.roles[roleIndex]
            if (role.name === 'ADMIN') {
                isAdmin = true;
            }
        }

        if (!isAdmin) {
            window.open('/', '_self');
        }
    }
})

$(document).ajaxError(function(event,xhr,options){
    window.open('/login', '_self');
});