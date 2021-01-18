var courseId
var unitId

console.log(courseId)
console.log(unitId)

window.onload = async function () {
    courseId = sessionStorage.getItem("courseId")
    unitId = sessionStorage.getItem("unitId")
    let students = $("#students")

    try {
        let plan = await $.ajax({
            url: `/api/plans/${courseId}/${unitId}`,
            method: "get",
            dataType: "json"
        });

        $("#unit").html(plan.unit.name)
        console.log(plan)

        let html = ""

        for (let enrolment of plan.enrolments)
            html += `<section class="btn" onclick='showStudent(${enrolment.id})'>
                        <h3 class="name">${enrolment.student.name}</h3>
                        <section class="grade">Grade: ${enrolment.grade ?? ''}</section>
                    </section>`

        students.html(html)
    } catch (err) {
        console.log(err)
        students.html("<h1> Page not available </h1>")
    }
}

function showStudent(id) {
    sessionStorage.setItem("enrolmentId", id);
    window.location = "student.html";
}