# 实验二：SOA 架构 Petstore (Lab2_SOA_Project)

这是一个基于现代 SOA (Service-Oriented Architecture) 思想构建的完整 JPetStore 宠物商店项目。

项目采用前后端分离架构，并以后端微服务的方式实现。前端使用 React 构建，后端使用 Spring Cloud 全家桶实现。

## 📁 项目结构

本项目是一个 Monorepo，包含两个主要模块：

* **`/mypetstore-fronts`**：前端 React (Vite) 应用。
* **`/Mypetstore-Microservice`**：后端 Java 微服务。
    * `/mypetstore-gateway`：Spring Cloud Gateway 网关 (运行于 `8070` 端口)。
    * `/mypetstore-user-service`：用户服务 (处理账户、登录、JWT)。
    * `/mypetstore-product-service`：商品服务 (处理商品、目录)。
    * `/mypetstore-order-service`：订单服务 (处理购物车、订单)。

## 🛠️ 技术栈

### 后端 (Mypetstore-Microservice)
* Spring Boot 3
* Spring Cloud (Gateway, Nacos)
* Spring Security (JWT 认证)
* Mybatis-Plus
* MySQL 数据库
* Maven

### 前端 (mypetstore-fronts)
* React
* Vite (推测)
* Axios (用于 API 请求)
* Node.js (npm)

## 🏁 运行指南

在运行此项目前，请确保你本地已安装并运行了以下必备环境。

### 1. 必备环境 (Prerequisites)

* **Java JDK 17+**
* **Maven 3.6+**
* **Node.js 18+**
* **MySQL 8.0+**
* **Nacos Server 2.x**

### 2. 数据库和 Nacos 设置

1.  **启动 MySQL**：
    确保你的 MySQL 服务正在运行。你需要**手动创建**一个数据库（例如 `petstore_user`, `petstore_order` 等，取决于你的微服务配置）。
    **重要**：你必须进入每一个微服务 (`user-service`, `product-service`, `order-service`) 的 `src/main/resources/application.properties` 文件，修改 `spring.datasource` 相关配置，指向你自己的数据库、用户名和密码。

2.  **启动 Nacos Server**：
    确保你的 Nacos 服务正在 `http://localhost:8848` 上运行。所有微服务和网关都会自动注册到这个地址。

### 3. 后端启动 (Backend)

**（推荐）使用 IDE 启动：**
1.  使用 IntelliJ IDEA 打开 `Mypetstore-Microservice` 这个 Maven 根项目。
2.  等待 Maven 自动同步所有依赖。
3.  **按顺序**启动所有微服务：
    * `MypetstoreUserServiceApplication`
    * `MypetstoreProductServiceApplication`
    * `MypetstoreOrderServiceApplication`
    * `MypetstoreGatewayApplication`

**（备选）使用 Maven 命令行启动：**
1.  打开一个终端，进入后端根目录：
    ```bash
    cd Mypetstore-Microservice
    ```
2.  构建所有模块（这会跳过 `target` 目录，因为它们在 `.gitignore` 中）：
    ```bash
    mvn clean install
    ```
3.  你需要打开 4 个独立的终端，分别启动每一个微服务：
    ```bash
    java -jar mypetstore-user-service/target/mypetstore-user-service-0.0.1-SNAPSHOT.jar
    java -jar mypetstore-product-service/target/mypetstore-product-service-0.0.1-SNAPSHOT.jar
    java -jar mypetstore-order-service/target/mypetstore-order-service-0.0.1-SNAPSHOT.jar
    java -jar mypetstore-gateway/target/mypetstore-gateway-0.0.1-SNAPSHOT.jar
    ```

### 4. 前端启动 (Frontend)

1.  打开**第二个**终端，进入前端目录：
    ```bash
    cd mypetstore-fronts
    ```
2.  安装依赖（`node_modules` 目录已通过 `.gitignore` 排除）：
    ```bash
    npm install
    ```
3.  启动本地开发服务器：
    ```bash
    npm run dev
    ```

## 🖥️ 访问项目

当所有服务都成功运行后，你可以访问：

* **前端应用**： `http://localhost:5173`
* **后端网关**： `http://localhost:8070`
* **Nacos 控制台**：`http://localhost:8848/nacos`