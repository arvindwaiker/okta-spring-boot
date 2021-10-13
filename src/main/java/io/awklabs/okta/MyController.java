package io.awklabs.okta;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@RequestMapping("/")
	public String greeting(@AuthenticationPrincipal OidcUser user) {
		if(user != null && user.getUserInfo() != null) {
			return "Hello " + user.getUserInfo().getFullName();
		} else {
			return "Hello Guest!";
		}
	}
}
