<template>
  <div id="app">
    <el-container style="height:100%;margin:0;padding:0;">
      <el-aside style="background-color: rgb(238, 241, 246);">
        <SysMenu></SysMenu>
      </el-aside>
      <el-container>
        <el-header type="brand" style="background-color: rgb(238, 241, 246);">测试Header</el-header>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import SysMenu from "./components/SysMenu";

export default {
  name: "app",
  components: {
    SysMenu
  }
};
</script>

<style>
body {
  margin: 0px;
}
#app,
html,
body,
.el-container {
  padding: 0px;
  margin: 0px;
  height: 100%;
}
</style>
