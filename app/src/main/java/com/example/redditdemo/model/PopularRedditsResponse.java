package com.example.redditdemo.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by webonise on 24/3/18.
 */

public class PopularRedditsResponse {

    @SerializedName("kind")
    private String _$Kind63; // FIXME check this code
    private DataBeanX data;

    public String get_$Kind63() {
        return _$Kind63;
    }

    public void set_$Kind63(String _$Kind63) {
        this._$Kind63 = _$Kind63;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        @SerializedName("after")
        private String _$After189; // FIXME check this code
        private int dist;
        private String modhash;
        private String whitelist_status;
        private Object before;
        private List<ChildrenBean> children;

        public String get_$After189() {
            return _$After189;
        }

        public void set_$After189(String _$After189) {
            this._$After189 = _$After189;
        }

        public int getDist() {
            return dist;
        }

        public void setDist(int dist) {
            this.dist = dist;
        }

        public String getModhash() {
            return modhash;
        }

        public void setModhash(String modhash) {
            this.modhash = modhash;
        }

        public String getWhitelist_status() {
            return whitelist_status;
        }

        public void setWhitelist_status(String whitelist_status) {
            this.whitelist_status = whitelist_status;
        }

        public Object getBefore() {
            return before;
        }

        public void setBefore(Object before) {
            this.before = before;
        }

        public List<ChildrenBean> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBean> children) {
            this.children = children;
        }

        public static class ChildrenBean {

            private String kind;
            private DataBean data;

            public String getKind() {
                return kind;
            }

            public void setKind(String kind) {
                this.kind = kind;
            }

            public DataBean getData() {
                return data;
            }

            public void setData(DataBean data) {
                this.data = data;
            }

            public static class DataBean {

                private Object suggested_comment_sort;
                private boolean hide_ads;
                private String banner_img;
                private boolean user_sr_theme_enabled;
                private Object user_flair_text;
                private String submit_text_html;
                private Object user_is_banned;
                private boolean wiki_enabled;
                private boolean show_media;
                private String id;
                private String display_name_prefixed;
                private String submit_text;
                private Object user_can_flair_in_sr;
                private String display_name;
                private String header_img;
                private String description_html;
                private String title;
                private boolean collapse_deleted_comments;
                private Object user_has_favorited;
                private boolean over18;
                private String public_description_html;
                private boolean allow_videos;
                private boolean spoilers_enabled;
                private String audience_target;
                private Object notification_level;
                private Object active_user_count;
                private String icon_img;
                private String header_title;
                private String description;
                private Object user_is_muted;
                private Object submit_link_label;
                private Object accounts_active;
                private boolean public_traffic;
                private int subscribers;
                private Object user_flair_css_class;
                private String submit_text_label;
                private String whitelist_status;
                private Object user_sr_flair_enabled;
                private String lang;
                private Object user_is_moderator;
                private Object is_enrolled_in_new_modmail;
                private String key_color;
                private String name;
                private boolean user_flair_enabled_in_sr;
                private boolean allow_videogifs;
                private String url;
                private boolean quarantine;
                private double created;
                private double created_utc;
                private Object user_is_contributor;
                private boolean allow_discovery;
                private boolean accounts_active_is_fuzzed;
                private String advertiser_category;
                private String public_description;
                private boolean link_flair_enabled;
                private boolean allow_images;
                private boolean show_media_preview;
                private int comment_score_hide_mins;
                private String subreddit_type;
                private String submission_type;
                private Object user_is_subscriber;
                private List<Integer> icon_size;
                private List<Integer> header_size;
                private List<Integer> banner_size;

                public Object getSuggested_comment_sort() {
                    return suggested_comment_sort;
                }

                public void setSuggested_comment_sort(Object suggested_comment_sort) {
                    this.suggested_comment_sort = suggested_comment_sort;
                }

                public boolean isHide_ads() {
                    return hide_ads;
                }

                public void setHide_ads(boolean hide_ads) {
                    this.hide_ads = hide_ads;
                }

                public String getBanner_img() {
                    return banner_img;
                }

                public void setBanner_img(String banner_img) {
                    this.banner_img = banner_img;
                }

                public boolean isUser_sr_theme_enabled() {
                    return user_sr_theme_enabled;
                }

                public void setUser_sr_theme_enabled(boolean user_sr_theme_enabled) {
                    this.user_sr_theme_enabled = user_sr_theme_enabled;
                }

                public Object getUser_flair_text() {
                    return user_flair_text;
                }

                public void setUser_flair_text(Object user_flair_text) {
                    this.user_flair_text = user_flair_text;
                }

                public String getSubmit_text_html() {
                    return submit_text_html;
                }

                public void setSubmit_text_html(String submit_text_html) {
                    this.submit_text_html = submit_text_html;
                }

                public Object getUser_is_banned() {
                    return user_is_banned;
                }

                public void setUser_is_banned(Object user_is_banned) {
                    this.user_is_banned = user_is_banned;
                }

                public boolean isWiki_enabled() {
                    return wiki_enabled;
                }

                public void setWiki_enabled(boolean wiki_enabled) {
                    this.wiki_enabled = wiki_enabled;
                }

                public boolean isShow_media() {
                    return show_media;
                }

                public void setShow_media(boolean show_media) {
                    this.show_media = show_media;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getDisplay_name_prefixed() {
                    return display_name_prefixed;
                }

                public void setDisplay_name_prefixed(String display_name_prefixed) {
                    this.display_name_prefixed = display_name_prefixed;
                }

                public String getSubmit_text() {
                    return submit_text;
                }

                public void setSubmit_text(String submit_text) {
                    this.submit_text = submit_text;
                }

                public Object getUser_can_flair_in_sr() {
                    return user_can_flair_in_sr;
                }

                public void setUser_can_flair_in_sr(Object user_can_flair_in_sr) {
                    this.user_can_flair_in_sr = user_can_flair_in_sr;
                }

                public String getDisplay_name() {
                    return display_name;
                }

                public void setDisplay_name(String display_name) {
                    this.display_name = display_name;
                }

                public String getHeader_img() {
                    return header_img;
                }

                public void setHeader_img(String header_img) {
                    this.header_img = header_img;
                }

                public String getDescription_html() {
                    return description_html;
                }

                public void setDescription_html(String description_html) {
                    this.description_html = description_html;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public boolean isCollapse_deleted_comments() {
                    return collapse_deleted_comments;
                }

                public void setCollapse_deleted_comments(boolean collapse_deleted_comments) {
                    this.collapse_deleted_comments = collapse_deleted_comments;
                }

                public Object getUser_has_favorited() {
                    return user_has_favorited;
                }

                public void setUser_has_favorited(Object user_has_favorited) {
                    this.user_has_favorited = user_has_favorited;
                }

                public boolean isOver18() {
                    return over18;
                }

                public void setOver18(boolean over18) {
                    this.over18 = over18;
                }

                public String getPublic_description_html() {
                    return public_description_html;
                }

                public void setPublic_description_html(String public_description_html) {
                    this.public_description_html = public_description_html;
                }

                public boolean isAllow_videos() {
                    return allow_videos;
                }

                public void setAllow_videos(boolean allow_videos) {
                    this.allow_videos = allow_videos;
                }

                public boolean isSpoilers_enabled() {
                    return spoilers_enabled;
                }

                public void setSpoilers_enabled(boolean spoilers_enabled) {
                    this.spoilers_enabled = spoilers_enabled;
                }

                public String getAudience_target() {
                    return audience_target;
                }

                public void setAudience_target(String audience_target) {
                    this.audience_target = audience_target;
                }

                public Object getNotification_level() {
                    return notification_level;
                }

                public void setNotification_level(Object notification_level) {
                    this.notification_level = notification_level;
                }

                public Object getActive_user_count() {
                    return active_user_count;
                }

                public void setActive_user_count(Object active_user_count) {
                    this.active_user_count = active_user_count;
                }

                public String getIcon_img() {
                    return icon_img;
                }

                public void setIcon_img(String icon_img) {
                    this.icon_img = icon_img;
                }

                public String getHeader_title() {
                    return header_title;
                }

                public void setHeader_title(String header_title) {
                    this.header_title = header_title;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public Object getUser_is_muted() {
                    return user_is_muted;
                }

                public void setUser_is_muted(Object user_is_muted) {
                    this.user_is_muted = user_is_muted;
                }

                public Object getSubmit_link_label() {
                    return submit_link_label;
                }

                public void setSubmit_link_label(Object submit_link_label) {
                    this.submit_link_label = submit_link_label;
                }

                public Object getAccounts_active() {
                    return accounts_active;
                }

                public void setAccounts_active(Object accounts_active) {
                    this.accounts_active = accounts_active;
                }

                public boolean isPublic_traffic() {
                    return public_traffic;
                }

                public void setPublic_traffic(boolean public_traffic) {
                    this.public_traffic = public_traffic;
                }

                public int getSubscribers() {
                    return subscribers;
                }

                public void setSubscribers(int subscribers) {
                    this.subscribers = subscribers;
                }

                public Object getUser_flair_css_class() {
                    return user_flair_css_class;
                }

                public void setUser_flair_css_class(Object user_flair_css_class) {
                    this.user_flair_css_class = user_flair_css_class;
                }

                public String getSubmit_text_label() {
                    return submit_text_label;
                }

                public void setSubmit_text_label(String submit_text_label) {
                    this.submit_text_label = submit_text_label;
                }

                public String getWhitelist_status() {
                    return whitelist_status;
                }

                public void setWhitelist_status(String whitelist_status) {
                    this.whitelist_status = whitelist_status;
                }

                public Object getUser_sr_flair_enabled() {
                    return user_sr_flair_enabled;
                }

                public void setUser_sr_flair_enabled(Object user_sr_flair_enabled) {
                    this.user_sr_flair_enabled = user_sr_flair_enabled;
                }

                public String getLang() {
                    return lang;
                }

                public void setLang(String lang) {
                    this.lang = lang;
                }

                public Object getUser_is_moderator() {
                    return user_is_moderator;
                }

                public void setUser_is_moderator(Object user_is_moderator) {
                    this.user_is_moderator = user_is_moderator;
                }

                public Object getIs_enrolled_in_new_modmail() {
                    return is_enrolled_in_new_modmail;
                }

                public void setIs_enrolled_in_new_modmail(Object is_enrolled_in_new_modmail) {
                    this.is_enrolled_in_new_modmail = is_enrolled_in_new_modmail;
                }

                public String getKey_color() {
                    return key_color;
                }

                public void setKey_color(String key_color) {
                    this.key_color = key_color;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public boolean isUser_flair_enabled_in_sr() {
                    return user_flair_enabled_in_sr;
                }

                public void setUser_flair_enabled_in_sr(boolean user_flair_enabled_in_sr) {
                    this.user_flair_enabled_in_sr = user_flair_enabled_in_sr;
                }

                public boolean isAllow_videogifs() {
                    return allow_videogifs;
                }

                public void setAllow_videogifs(boolean allow_videogifs) {
                    this.allow_videogifs = allow_videogifs;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public boolean isQuarantine() {
                    return quarantine;
                }

                public void setQuarantine(boolean quarantine) {
                    this.quarantine = quarantine;
                }

                public double getCreated() {
                    return created;
                }

                public void setCreated(double created) {
                    this.created = created;
                }

                public double getCreated_utc() {
                    return created_utc;
                }

                public void setCreated_utc(double created_utc) {
                    this.created_utc = created_utc;
                }

                public Object getUser_is_contributor() {
                    return user_is_contributor;
                }

                public void setUser_is_contributor(Object user_is_contributor) {
                    this.user_is_contributor = user_is_contributor;
                }

                public boolean isAllow_discovery() {
                    return allow_discovery;
                }

                public void setAllow_discovery(boolean allow_discovery) {
                    this.allow_discovery = allow_discovery;
                }

                public boolean isAccounts_active_is_fuzzed() {
                    return accounts_active_is_fuzzed;
                }

                public void setAccounts_active_is_fuzzed(boolean accounts_active_is_fuzzed) {
                    this.accounts_active_is_fuzzed = accounts_active_is_fuzzed;
                }

                public String getAdvertiser_category() {
                    return advertiser_category;
                }

                public void setAdvertiser_category(String advertiser_category) {
                    this.advertiser_category = advertiser_category;
                }

                public String getPublic_description() {
                    return public_description;
                }

                public void setPublic_description(String public_description) {
                    this.public_description = public_description;
                }

                public boolean isLink_flair_enabled() {
                    return link_flair_enabled;
                }

                public void setLink_flair_enabled(boolean link_flair_enabled) {
                    this.link_flair_enabled = link_flair_enabled;
                }

                public boolean isAllow_images() {
                    return allow_images;
                }

                public void setAllow_images(boolean allow_images) {
                    this.allow_images = allow_images;
                }

                public boolean isShow_media_preview() {
                    return show_media_preview;
                }

                public void setShow_media_preview(boolean show_media_preview) {
                    this.show_media_preview = show_media_preview;
                }

                public int getComment_score_hide_mins() {
                    return comment_score_hide_mins;
                }

                public void setComment_score_hide_mins(int comment_score_hide_mins) {
                    this.comment_score_hide_mins = comment_score_hide_mins;
                }

                public String getSubreddit_type() {
                    return subreddit_type;
                }

                public void setSubreddit_type(String subreddit_type) {
                    this.subreddit_type = subreddit_type;
                }

                public String getSubmission_type() {
                    return submission_type;
                }

                public void setSubmission_type(String submission_type) {
                    this.submission_type = submission_type;
                }

                public Object getUser_is_subscriber() {
                    return user_is_subscriber;
                }

                public void setUser_is_subscriber(Object user_is_subscriber) {
                    this.user_is_subscriber = user_is_subscriber;
                }

                public List<Integer> getIcon_size() {
                    return icon_size;
                }

                public void setIcon_size(List<Integer> icon_size) {
                    this.icon_size = icon_size;
                }

                public List<Integer> getHeader_size() {
                    return header_size;
                }

                public void setHeader_size(List<Integer> header_size) {
                    this.header_size = header_size;
                }

                public List<Integer> getBanner_size() {
                    return banner_size;
                }

                public void setBanner_size(List<Integer> banner_size) {
                    this.banner_size = banner_size;
                }
            }
        }
    }
}
