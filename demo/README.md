# 食品店ERP系统

## 项目概述
这是一个基于Java Spring Boot开发的食品店ERP（企业资源计划）系统，旨在帮助食品店管理日常运营，包括库存管理、订单处理、供应商管理、销售统计等功能。

## 系统架构

### 技术栈
- 后端：Spring Boot, Spring Data JPA, Spring Security
- 数据库：MySQL
- 前端：Thymeleaf, Bootstrap, jQuery

### 系统模块
1. **用户管理**：用户认证、授权和角色管理
2. **商品管理**：商品信息、分类和价格管理
3. **库存管理**：库存水平监控、进出库记录
4. **订单管理**：订单创建、处理和跟踪
5. **供应商管理**：供应商信息和采购管理
6. **销售管理**：销售记录和客户管理
7. **报表系统**：销售报表、库存报表、财务报表

## 数据库设计

### 主要实体

#### 用户(User)
- id: Long (主键)
- username: String (用户名)
- password: String (密码)
- name: String (姓名)
- email: String (邮箱)
- phone: String (电话)
- role: Enum (角色：ADMIN, MANAGER, STAFF)
- active: Boolean (是否激活)
- createdAt: DateTime (创建时间)
- updatedAt: DateTime (更新时间)

#### 商品(Product)
- id: Long (主键)
- name: String (商品名称)
- description: String (描述)
- category: Category (商品分类)
- price: BigDecimal (价格)
- cost: BigDecimal (成本)
- sku: String (库存单位)
- barcode: String (条形码)
- active: Boolean (是否激活)
- createdAt: DateTime (创建时间)
- updatedAt: DateTime (更新时间)

#### 商品分类(Category)
- id: Long (主键)
- name: String (分类名称)
- description: String (描述)
- parentCategory: Category (父分类)

#### 库存(Inventory)
- id: Long (主键)
- product: Product (商品)
- quantity: Integer (数量)
- location: String (库位)
- updatedAt: DateTime (更新时间)

#### 库存记录(InventoryTransaction)
- id: Long (主键)
- product: Product (商品)
- quantity: Integer (数量)
- type: Enum (类型：IN, OUT)
- reason: String (原因)
- reference: String (参考号)
- createdBy: User (创建人)
- createdAt: DateTime (创建时间)

#### 供应商(Supplier)
- id: Long (主键)
- name: String (供应商名称)
- contactPerson: String (联系人)
- email: String (邮箱)
- phone: String (电话)
- address: String (地址)
- active: Boolean (是否激活)
- createdAt: DateTime (创建时间)
- updatedAt: DateTime (更新时间)

#### 采购订单(PurchaseOrder)
- id: Long (主键)
- orderNumber: String (订单号)
- supplier: Supplier (供应商)
- status: Enum (状态：DRAFT, SUBMITTED, APPROVED, RECEIVED, CANCELLED)
- totalAmount: BigDecimal (总金额)
- createdBy: User (创建人)
- approvedBy: User (审批人)
- createdAt: DateTime (创建时间)
- updatedAt: DateTime (更新时间)

#### 采购订单项(PurchaseOrderItem)
- id: Long (主键)
- purchaseOrder: PurchaseOrder (采购订单)
- product: Product (商品)
- quantity: Integer (数量)
- unitPrice: BigDecimal (单价)
- totalPrice: BigDecimal (总价)

#### 销售订单(SalesOrder)
- id: Long (主键)
- orderNumber: String (订单号)
- customer: String (客户)
- status: Enum (状态：NEW, PROCESSING, COMPLETED, CANCELLED)
- totalAmount: BigDecimal (总金额)
- createdBy: User (创建人)
- createdAt: DateTime (创建时间)
- updatedAt: DateTime (更新时间)

#### 销售订单项(SalesOrderItem)
- id: Long (主键)
- salesOrder: SalesOrder (销售订单)
- product: Product (商品)
- quantity: Integer (数量)
- unitPrice: BigDecimal (单价)
- totalPrice: BigDecimal (总价)

## 功能特性

### 用户管理
- 用户注册和登录
- 基于角色的权限控制
- 用户信息管理

### 商品管理
- 商品添加、编辑和删除
- 商品分类管理
- 商品价格管理

### 库存管理
- 库存水平监控
- 库存进出记录
- 库存预警

### 订单管理
- 销售订单创建和处理
- 采购订单管理
- 订单状态跟踪

### 供应商管理
- 供应商信息管理
- 采购管理

### 报表系统
- 销售报表
- 库存报表
- 财务报表

## 安装和部署

### 系统要求
- JDK 11+
- Maven 3.6+
- MySQL 8.0+

### 安装步骤
1. 克隆项目代码
2. 配置数据库连接
3. 使用Maven构建项目
4. 运行应用程序

## 开发计划
1. 基础架构搭建
2. 用户认证和权限管理
3. 商品和库存管理
4. 订单管理系统
5. 供应商管理
6. 报表和统计分析
7. 前端界面优化
8. 测试和部署