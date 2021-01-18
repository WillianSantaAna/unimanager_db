var courseId;
window.onload = async function () {
    courseId = sessionStorage.getItem("courseId");
    try {
        let course = await $.ajax({
            url: `/api/courses/${courseId}`,
            method: "get", dataType: "json"
        });
        document.getElementById("course").innerHTML = course.name;
        let existingIds = [];
        for (let plan of course.plans) existingIds.push(plan.unit.id);
        let html = "";
        let units = await $.ajax({
            url: "/api/units", method: "get", dataType: "json"
        });
        for (let unit of units)
            if (!existingIds.includes(unit.id))
                html += `<option value=${unit.id}>${unit.name} (${unit.credits} credits) </option>`;
        document.getElementById("unit").innerHTML = html;
    } catch (err) {
        console.log(err);
    }
}

async function add() {
    let unitId = document.getElementById("unit").value;
    let semester = document.getElementById("semester").value;
    let data = {
        course: {
            id: parseInt(courseId)
        },
        unit: {
            id: parseInt(unitId)
        },
        semester: parseInt(semester)
    };
    
    try {
        let result = await $.ajax({
            url: `/api/courses/${courseId}/units`,
            method: "post",
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",
        });

        document.getElementById("result").innerHTML = result.result;
    } catch (err) {
        console.log(err);
    }
}