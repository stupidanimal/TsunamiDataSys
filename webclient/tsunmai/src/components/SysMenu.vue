<template>
  <!-- <el-menu default-active="2" @open="handleOpen" @close="handleClose">
    <el-submenu index="1">
      <template slot="title">
        <i class="el-icon-location"></i>
        <span>导航一</span>
      </template>
      <el-menu-item-group>
        <template slot="title">分组一</template>
        <el-menu-item index="1-1">选项1</el-menu-item>
        <el-menu-item index="1-2">选项2</el-menu-item>
      </el-menu-item-group>
      <el-menu-item-group title="分组2">
        <el-menu-item index="1-3">选项3</el-menu-item>
      </el-menu-item-group>
      <el-submenu index="1-4">
        <template slot="title">选项4</template>
        <el-menu-item index="1-4-1">选项1</el-menu-item>
      </el-submenu>
    </el-submenu>
    <el-menu-item index="2">
      <i class="el-icon-menu"></i>
      <span slot="title">导航二</span>
    </el-menu-item>
    <el-menu-item index="3" disabled>
      <i class="el-icon-document"></i>
      <span slot="title">导航三</span>
    </el-menu-item>
    <el-menu-item index="4">
      <i class="el-icon-setting"></i>
      <span slot="title">导航四</span>
    </el-menu-item>
  </el-menu>-->

  <el-menu default-active="2">
    <el-submenu v-for="(menu,idx) in Menus" :index="idx.toString()" v-bind:key="idx">
      <template slot="title">
        <i :class="menu.menuIconClass"></i>
        <span :title="menu.menuContent">{{menu.menuTitle}}</span>
      </template>
      <el-menu-item-group>
        <el-menu-item
          v-for="(subMenu,subIdx) in menu.children"
          v-bind:key="subIdx"
          :index="subMenu.menuID.toString()"
        >
          <router-link :to="subMenu.menuUrl">{{subMenu.menuTitle}}</router-link>
        </el-menu-item>
      </el-menu-item-group>
    </el-submenu>
  </el-menu>
</template>

<script>
import axios from "axios";
// import router from "vue-router";
// import Vue from "vue";

//menu导出来应该是树形结构{{},{}}
export default {
  data() {
    return {
      MenusArr: null,
      Menus: []
    };
  },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    buildMenu() {
      if (this.MenusArr != null || this.MenusArr.length > 0) {
        //暂时先只找两层
        let parentArr = [],
          childrenArr = [];
        parentArr = this.MenusArr.filter(x => x.parentID == 0);
        childrenArr = this.MenusArr.filter(x => x.parentID != 0);
        for (let i in childrenArr) {
          let subMenu = childrenArr[i];
          let parentMenu = parentArr.find(x => x.menuID == subMenu.parentID);
          if (parentMenu.children == undefined) {
            parentMenu.children = [];
          }
          parentMenu.children.push(subMenu);
        }
        //排序
        for (let i in parentArr) {
          let temp = parentArr[i];
          temp.children = temp.children.sort(x => x.menuOrder);
        }
        this.Menus = parentArr;

        console.log(parentArr);
      }
    }
  },
  mounted() {
    let that = this;
    axios
      .get("http://localhost:8082/station/test")
      .then(x => {
        if (x.status === 200) {
          that.MenusArr = x.data;
          this.buildMenu();
        }
      })
      .catch(e => {
        console.log(e);
      });
  }
};
</script>