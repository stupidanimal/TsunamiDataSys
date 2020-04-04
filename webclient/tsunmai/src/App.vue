<template>
  <div id="app">
    <el-container>
      <!-- <el-container> -->
      <el-aside>
        <SysMenu></SysMenu>
      </el-aside>
      <!-- </el-container> -->
      <el-container>
        <el-header type="brand">海啸系统</el-header>
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
</style>
