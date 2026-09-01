    package com.howe.lifefragmentshop.pojo;

    import java.math.BigDecimal;//金钱的类型

    public class LifeFragment {//生命碎片
        //生命碎片表： id、商品名、库存、描述、价格、图片、状态
        private int id;
        private String name;
        private int stock;//数量
        private String description;//描述
        private BigDecimal price;
        private String img;//图片不知道用什么类型，暂定字符串
        private int state;//当前状态,1就是上架，0就是下架

        //无参构造器
        public LifeFragment(){
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

    }
