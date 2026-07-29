self.onmessage = async function (event) {
    try {
        const response = await fetch(event.data);

        if (!response.ok) {
            throw new Error("Failed to fetch users");
        }

        const result = await response.json();

        if (!result.users || result.users.length === 0) {
            self.postMessage([]);
            return;
        }

        const users = result.users.map(user => ({
            name: `${user.firstName} ${user.lastName}`,
            status: "Active"
        }));

        self.postMessage(users);

    } catch (error) {
        self.postMessage({
            error: "No users found"
        });
    }
};