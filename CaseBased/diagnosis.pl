find_diagnose(KP, KS, LP, HP, chronic_knee_pain) :- compare(=, KP, knee_)

find_diagnose(HP, LP, KP, osteoarthritis) :- compare(= , HP, hip_pain), compare(=, LP, leg_pain), compare(=, KP, knee_pain),!.