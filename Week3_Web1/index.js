const usersDiv = document.getElementById("users");
const worker = new Worker("worker.js");

worker.postMessage("https://dummyjson.com/users");

worker.onmessage = function (event) {
    const data = event.data;

    if (data.error) {
        usersDiv.textContent = data.error;
        return;
    }

    if (data.length === 0) {
        usersDiv.textContent = "No users found";
        return;
    }

    usersDiv.innerHTML = "";

    data.forEach(user => {
        const p = document.createElement("p");
        p.textContent = `${user.name} - ${user.status}`;
        usersDiv.appendChild(p);
    });
};