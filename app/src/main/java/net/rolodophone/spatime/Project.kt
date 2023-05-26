package net.rolodophone.spatime

import androidx.annotation.ColorInt

enum class Project(val projectName: String, colour: Long, val dark: Boolean, val drawableResource: Int) {
	MORNING_ROUTINE(		"Morning Routine",			0xFFE1BEE7, false,	R.drawable.alarm),
	CONTACT_HOURS(			"Contact Hours",			0xFFB71C1C, true, 	R.drawable.domain),
	LUNCH(					"Lunch",					0xFFBBDEFB, false,	R.drawable.food_apple_outline),
	STUDYING_COURSEWORK(	"Studying & Coursework",	0xFFEF6C00, false,	R.drawable.desk_lamp),
	AFTERNOON_ROUTINE(		"Afternoon Routine",		0xFF9575CD, false,	R.drawable.home_city_outline),

	COOKING(				"Cooking",					0xFF80DEEA, false,	R.drawable.pot_steam_outline),
	DINNER(					"Dinner",					0xFF6D4C41, true,	R.drawable.food_turkey),
	BEDTIME_ROUTINE(		"Bedtime Routine",			0xFF4527A0, true,	R.drawable.bed_clock),
	SLEEP(					"Sleep", 					0xFF00838F, true,	R.drawable.bed_outline),
	EMAILS_MESSAGES(		"Emails & Messages", 		0xFF757575, false,	R.drawable.email_outline),

	SHOPPING(				"Shopping", 				0xFFB0BEC5, false,	R.drawable.cart_outline),
	BREAKS(					"Breaks", 					0xFFFF7043, false,	R.drawable.coffee_outline),
	HYGIENE_SELF_CARE(		"Hygiene & Self-Care", 		0xFF80DEEA, false,	R.drawable.shower),
	SPORTS_WORKOUTS(		"Sports & Workouts", 		0xFF212121, true,	R.drawable.dumbbell),
	LANGUAGE_LEARNING(		"Language-Learning", 		0xFFAD1457, false,	R.drawable.translate),

	CAREER(					"Career",					0xFFDCE775, false,	R.drawable.card_account_details_outline),
	TASK_MANAGEMENT(		"Task Management", 			0xFF00C853, false,	R.drawable.order_bool_ascending_variant),
	SOCIAL_MEDIA(			"Social Media", 			0xFFF50057, false,	R.drawable.instagram),
	TV_VIDEOS(				"TV & Videos",				0xFFD50000, false,	R.drawable.youtube_tv),
	COMEDY(					"Comedy",					0xFF004D40, true,	R.drawable.microphone_variant),

	EFFECTIVE_ALTRUISM(		"Effective Altruism",		0xFFFFA726, false,	R.drawable.hand_heart),
	READING(				"Reading",					0xFF1A237E, true,	R.drawable.bookshelf),
	HOUSEWORK(				"Housework",				0xFFDCE775, false,	R.drawable.broom),
	SOCIAL(					"Social",					0xFF8BC34A, false,	R.drawable.account_group_outline),
	VIDEO_GAMES(			"Video Games",				0xFF1B5E20, true,	R.drawable.controller),

	CONTEMPLATION(			"Contemplation",			0xFF80CBC4, false,	R.drawable.meditation),
	OTHER(					"Other",					0xFF00B0FF, false,	R.drawable.dots_horizontal),
	FAMILY(					"Family",					0xFF01579B, true,	R.drawable.human_male_female_child),
	OLDEST_FORM(			"Oldest Form",				0xFF304FFE, false,	R.drawable.history),
	SOFTWARE_MAINTENANCE(	"Software Maintenance",		0xFF37474F, true,	R.drawable.wrench_cog_outline),

	RELATIONSHIP(			"Relationship",				0xFFF06292, false,	R.drawable.heart_outline),
	BACKLOG(				"Backlog",					0xFFF44336, false,	R.drawable.file_cabinet),
	TRAVELLING(				"Travelling",				0xFF827717, false,	R.drawable.train_car),
	DISTRACTION(			"Distraction", 				0xFF000000, true,	R.drawable.timer_sand_complete),
	PIANO(					"Piano",					0xFFECEFF1, false,	R.drawable.piano);

	@ColorInt val colour = colour.toInt()
}