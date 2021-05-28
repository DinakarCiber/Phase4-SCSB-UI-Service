package org.recap.security.cas;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.recap.BaseTestCaseUT;
import org.springframework.security.cas.authentication.CasAuthenticationProvider;
import org.springframework.security.cas.authentication.StatelessTicketCache;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;


public class CasAuthenticationProviderUT extends BaseTestCaseUT {

    @Mock
    CasAuthenticationProvider casAuthenticationProvider;

    @Mock
    Authentication authentication;

    @Mock
    StatelessTicketCache statelessTicketCache;

    @Mock
    GrantedAuthoritiesMapper authoritiesMapper;

    @Test
    public void authenticate(){

        Mockito.doCallRealMethod().when(casAuthenticationProvider).authenticate(authentication);
        Authentication auth = casAuthenticationProvider.authenticate(authentication);
    }
  /* *//* @Test
    public void getStatelessTicketCache(){
        StatelessTicketCache cache = casAuthenticationProvider.getStatelessTicketCache();
        assertNotNull(cache);
    }*//*
    @Test
    public void setStatelessTicketCache(){
        casAuthenticationProvider.setStatelessTicketCache(statelessTicketCache);
    }
    @Test
    public void setAuthoritiesMapper(){
        casAuthenticationProvider.setAuthoritiesMapper(authoritiesMapper);
    }
    @Test
    public void supports(){
        casAuthenticationProvider.supports(authentication.getClass());
    }*/
}
