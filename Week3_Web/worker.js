self.onmessage = function (event) {
    const users = event.data;

    users.forEach((user) => {

        // DummyJSON does not have an "active" field,
        // so we are displaying Active for demonstration.
        const status = "Active";

        self.postMessage(`${user.firstName} ${user.lastName} - ${status}`);
    });
};