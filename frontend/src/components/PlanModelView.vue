<template>

    <v-data-table
        :headers="headers"
        :items="planModel"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'PlanModelView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "memberId", value: "memberId" },
                { text: "location", value: "location" },
                { text: "startDay", value: "startDay" },
                { text: "endDay", value: "endDay" },
                { text: "budget", value: "budget" },
                { text: "groupSize", value: "groupSize" },
                { text: "details", value: "details" },
            ],
            planModel : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/planModels'))

            temp.data._embedded.planModels.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.planModel = temp.data._embedded.planModels;
        },
        methods: {
        }
    }
</script>

