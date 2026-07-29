const worker = new Worker("worker.js");

fetch("https://dummyjson.com/users")      // Replace with https://dummyapi.com/users if required
    .then((response) => {
        if (!response.ok) {
            throw new Error("Failed to fetch data");
        }
        return response.json();
    })
    .then((data) => {
        if (!data.users || data.users.length === 0) {
            throw new Error("No users returned from the API");
        }

        worker.postMessage(data.users);
    })
    .catch((error) => {
        console.error("Error:", error.message);
    });

worker.onmessage = function (event) {
    console.log(event.data);
};