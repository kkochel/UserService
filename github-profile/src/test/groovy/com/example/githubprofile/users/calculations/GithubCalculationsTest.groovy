package com.example.githubprofile.users.calculations

import spock.lang.Specification

class GithubCalculationsTest extends Specification {

    def githubCalculations = new GithubCalculations()

    def "User has followers and public repositories" () {
        given:
        def followers = 33
        def publicRepositories = 100

        when:
        def result = githubCalculations.calculation(followers, publicRepositories)

        then:
        !Double.isInfinite(result)
    }

    def "User has not followers and has public repositories" () {
        given:
        def followers = 0
        def publicRepositories = 100

        when:
        def result = githubCalculations.calculation(followers, publicRepositories)

        then:
        !Double.isInfinite(result)
    }

    def "User has followers and has not public repositories" () {
        given:
        def followers = 25
        def publicRepositories = 0

        when:
        def result = githubCalculations.calculation(followers, publicRepositories)

        then:
        !Double.isInfinite(result)
    }

    def "User has not followers and public repositories" () {
        given:
        def followers = 0
        def publicRepositories = 0

        when:
        def result = githubCalculations.calculation(followers, publicRepositories)

        then:
        !Double.isInfinite(result)
    }

    def "Invalid value of followers" () {
        given:
        def followers = -10
        def publicRepositories = 0

        when:
        def result = githubCalculations.calculation(followers, publicRepositories)

        then:
        !Double.isInfinite(result)
    }

    def "Invalid value of repositories" () {
        given:
        def followers = 0
        def publicRepositories = -13

        when:
        def result = githubCalculations.calculation(followers, publicRepositories)

        then:
        !Double.isInfinite(result)
    }
}
