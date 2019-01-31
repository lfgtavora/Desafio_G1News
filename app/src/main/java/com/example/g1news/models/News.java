package com.example.g1news.models;

public class News {

    private content content;
    private String age;
    private String type;

    public News(News.content content, String age, String type) {
        this.content = content;
        this.age = age;
        this.type = type;
    }

    public News.content getContent() {
        return content;
    }

    public void setContent(News.content content) {
        this.content = content;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public class content{

        private String section;
        private String summary;
        private String title;
        private String url;
        private image image;

        public content(String section, String summary, String title, String url, News.content.image image) {
            this.section = section;
            this.summary = summary;
            this.title = title;
            this.url = url;
            this.image = image;
        }

        public String getSection() {
            return section;
        }

        public void setSection(String section) {
            this.section = section;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public News.content.image getImage() {
            return image;
        }

        public void setImage(News.content.image image) {
            this.image = image;
        }

        public class image {
            private sizes sizes;

            public image(News.content.image.sizes sizes) {
                this.sizes = sizes;
            }

            public News.content.image.sizes getSizes() {
                return sizes;
            }

            public void setSizes(News.content.image.sizes sizes) {
                this.sizes = sizes;
            }

            public class sizes {
                private L L;

                public sizes(sizes.L l) {
                    L = l;
                }

                public sizes.L getL() {
                    return L;
                }

                public void setL(sizes.L l) {
                    L = l;
                }

                public class L {
                    private String url;

                    public L(String url) {
                        this.url = url;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }
                }
            }
        }


    }
}
