var enrolmentId

window.onload = async function () {
    enrolmentId = sessionStorage.getItem("enrolmentId")
    let studentInfo = $("#studentInfo")

    try {
        let enrolment = await $.ajax({
            url: `/api/enrolments/${enrolmentId}`,
            method: "get",
            dataType: "json",
        });

        $("#student").html(enrolment.student.name)

        let html = "";
        html += `<h2>${enrolment.plan.course.name}</h2>
                <h3>${enrolment.plan.unit.name}</h3>
                <ul>
                    <li>Id: ${enrolment.student.id}</li>
                    <li>Email: ${enrolment.student.email}</li>
                    <li>Address: ${enrolment.student.address}</li>
                    <li>Birth Date: ${enrolment.student.birthDate}</li>
                    <li>Gender: ${enrolment.student.gender}</li>
                </ul>
                <p class="gradeValue"><strong>Grade ${enrolment.grade}</strong></p>`

        studentInfo.html(html)
    } catch (err) {
        console.log(err);
        studentInfo.html("<h1> Page not available </h1>")
    }
}

async function setGrade() {
    let grade = $("#grade").val()

    if (grade >= 0 && grade <= 20) {
        try {
            let response = await $.ajax({
                url: `/api/enrolments/${enrolmentId}/grade`,
                method: "put",
                data: JSON.stringify(parseFloat(grade)),
                dataType: "json",
                contentType: "application/json",
            });
    
            $("#studentInfo .gradeValue").html(`Grade ${grade}`)
            $("#response").html(response.result)
        } catch (err) {
            console.log(err);
        }
    } else {
        alert("Grade value must be between 0 and 20")
    }
}