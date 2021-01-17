var courseId;

window.onload = async function () {
    courseId = sessionStorage.getItem("courseId");
    let elem = document.getElementById("units");
    try {
        let course = await $.ajax({
            url: `/api/courses/${courseId}`, method: "get", dataType: "json"
        });
        document.getElementById("course").innerHTML = course.name;
        let html = "";
        for (let plan of course.plans)
            html += `<section onclick='showUnit(${plan.unit.id})'>
                    <section class="sem">${plan.semester} Sem</section>
                    <section class="cre">Credits ${plan.unit.credits}</section>
                    <h3 class="name">${plan.unit.name}</h3>
                    </section>`
        elem.innerHTML = html;
    } catch (err) {
        console.log(err);
        elem.innerHTML = "<h1> Page not vailable </h1>";
    }
}

function showUnit(id) {
    sessionStorage.setItem("unitId", id);
    // Next steps here
}