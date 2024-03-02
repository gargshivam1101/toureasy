package model.bl.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.entity.Guide;
import model.enums.Role;

public class GuideService {

	static List<Guide> guideList = new ArrayList<>();

	public static List<Guide> getGuideList() {
		return UserService.getUserList().stream().filter(u -> u.getRole().equals(Role.GUIDE))
				.map(u -> new Guide(u, 500.0)).collect(Collectors.toList());
	}

	public static Guide getGuideByEmail(String email) {
		return getGuideList().stream().filter(g -> email.equalsIgnoreCase(g.getEmail())).findFirst().orElse(null);
	}
}
