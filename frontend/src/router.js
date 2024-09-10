
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import Manager from "./components/listers/Cards"
import Detail from "./components/listers/Detail"

import MemberMemberManager from "./components/listers/MemberMemberCards"
import MemberMemberDetail from "./components/listers/MemberMemberDetail"

import NotificationNotificationManager from "./components/listers/NotificationNotificationCards"
import NotificationNotificationDetail from "./components/listers/NotificationNotificationDetail"

import FollowFollowManager from "./components/listers/FollowFollowCards"
import FollowFollowDetail from "./components/listers/FollowFollowDetail"

import RecommendationRecommendationManager from "./components/listers/RecommendationRecommendationCards"
import RecommendationRecommendationDetail from "./components/listers/RecommendationRecommendationDetail"

import LikeLikeManager from "./components/listers/LikeLikeCards"
import LikeLikeDetail from "./components/listers/LikeLikeDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '//',
                name: 'Manager',
                component: Manager
            },
            {
                path: '///:id',
                name: 'Detail',
                component: Detail
            },

            {
                path: '/members/members',
                name: 'MemberMemberManager',
                component: MemberMemberManager
            },
            {
                path: '/members/members/:id',
                name: 'MemberMemberDetail',
                component: MemberMemberDetail
            },

            {
                path: '/notifications/notifications',
                name: 'NotificationNotificationManager',
                component: NotificationNotificationManager
            },
            {
                path: '/notifications/notifications/:id',
                name: 'NotificationNotificationDetail',
                component: NotificationNotificationDetail
            },

            {
                path: '/follows/follows',
                name: 'FollowFollowManager',
                component: FollowFollowManager
            },
            {
                path: '/follows/follows/:id',
                name: 'FollowFollowDetail',
                component: FollowFollowDetail
            },

            {
                path: '/recommendations/recommendations',
                name: 'RecommendationRecommendationManager',
                component: RecommendationRecommendationManager
            },
            {
                path: '/recommendations/recommendations/:id',
                name: 'RecommendationRecommendationDetail',
                component: RecommendationRecommendationDetail
            },

            {
                path: '/likes/likes',
                name: 'LikeLikeManager',
                component: LikeLikeManager
            },
            {
                path: '/likes/likes/:id',
                name: 'LikeLikeDetail',
                component: LikeLikeDetail
            },



    ]
})
