window.onload = async function () {
    let elem = document.getElementById("courses");
    try {
        let courses = await $.ajax({
            url: "/api/courses",
            method: "get",
            dataType: "json"
        });
        let html = "";
        for (let course of courses)
            html += `<section class="btn-course" onclick="showCourse(${course.id})">${course.name}</section>`
        elem.innerHTML = html;
    } catch (err) {
        console.log(err);
        elem.innerHTML = "<h1> Page not vailable </h1>";
    }
}

function showCourse(id) {
    sessionStorage.setItem("courseId", id);
    window.location = "course.html";
}