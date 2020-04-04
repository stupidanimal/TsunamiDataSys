<template>
  <div class="home">
    <Panel1 />
  </div>
</template>

<script>
// @ is an alias to /src
import Panel1 from "@/components/Panel1.vue";

export default {
  name: "Home",
  components: {
    Panel1
  }
};
</script>
