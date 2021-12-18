package com.example.sprintmongo.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.sprintmongo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.accept.ContentNegotiationStrategy;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {WebSecurityConfig.class, AuthenticationManagerBuilder.class,
        AuthenticationConfiguration.class})
@ExtendWith(SpringExtension.class)
class WebSecurityConfigTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;

    @MockBean
    private AuthenticationTrustResolver authenticationTrustResolver;

    @MockBean
    private ContentNegotiationStrategy contentNegotiationStrategy;

    @Autowired
    private ObjectPostProcessor<Object> objectPostProcessor;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private WebSecurityConfig webSecurityConfig;

    @Test
    void testUserDetailsService() {
        assertTrue(this.webSecurityConfig.userDetailsService() instanceof CustomUserDetailsService);
    }

    @Test
    void testPasswordEncoder() {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by passwordEncoder()
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        this.webSecurityConfig.passwordEncoder();
    }

    @Test
    void testAuthenticationProvider() {
        DaoAuthenticationProvider actualAuthenticationProviderResult = (new WebSecurityConfig()).authenticationProvider();
        assertTrue(actualAuthenticationProviderResult
                .getUserCache() instanceof org.springframework.security.core.userdetails.cache.NullUserCache);
        assertTrue(actualAuthenticationProviderResult.isHideUserNotFoundExceptions());
        assertFalse(actualAuthenticationProviderResult.isForcePrincipalAsString());
    }

    @Test
    void testConfigure() throws Exception {
        this.webSecurityConfig.configure(this.authenticationManagerBuilder);
        assertTrue(this.authenticationManagerBuilder.isConfigured());
        assertTrue(this.authenticationManagerBuilder
                .getOrBuild() instanceof org.springframework.security.authentication.ProviderManager);
    }
}

