%lekovi za odredjene bolesti pluca i ucestalost njihovog koriscenja(procenat)

%asthma
medication(asthma,albuterol,100).
medication(asthma,prednisone,83).
medication(asthma,montelukast,78).
medication(asthma,ipratropium,68).
medication(asthma,levalbuterol,51).
medication(asthma,terbutaline,10).

%pneumonia
medication(pneumonia,azithromycin,100).
medication(pneumonia,ceftriaxone,95).
medication(pneumonia,moxifloxacin,80).
medication(pneumonia,zosyn,66).
medication(pneumonia,robitussin_ac,43).
medication(pneumonia,cefepime,39).
medication(pneumonia,ceftazidime, 22).
medication(pneumonia,piperacillin,7).

%chronic obstructive pulmonary disease
medication(chronic_obstructive_pulmonary_disease,azithromycin,100).
medication(chronic_obstructive_pulmonary_disease,combivent,83).
medication(chronic_obstructive_pulmonary_disease,tiotropium,78).
medication(chronic_obstructive_pulmonary_disease,guaifenesin,71).
medication(chronic_obstructive_pulmonary_disease,levalbuterol,67).
medication(chronic_obstructive_pulmonary_disease,clarithromycin,41).
medication(chronic_obstructive_pulmonary_disease,theophylline,14).

%acute bronchitis
medication(acute_bronchitis,azithromycin,100).
medication(acute_bronchitis,guaifenesin,73).
medication(acute_bronchitis,benzonatate,54).
medication(acute_bronchitis,robitussin_ac,49).
medication(acute_bronchitis,clarithromycin,43).
medication(acute_bronchitis,dextromethorphan,9).

%pulmonary hypertension
medication(pulmonary_hypertension,furosemide,100).
medication(pulmonary_hypertension,warfarin,81).
medication(pulmonary_hypertension,carvedilol,63).
medication(pulmonary_hypertension,sildenafil,57). 
medication(pulmonary_hypertension,spironolactone,55).
medication(pulmonary_hypertension,digoxin,38).
medication(pulmonary_hypertension,bosentan,34).
medication(pulmonary_hypertension,bumetanide,17).
medication(pulmonary_hypertension,oxygen,10).

%pulmonary fibrosis
medication(pulmonary_fibrosis,prednisone,100).
medication(pulmonary_fibrosis,tiotropium,72).
medication(pulmonary_fibrosis,oxygen,58).
medication(pulmonary_fibrosis,acetylcysteine,44).
medication(pulmonary_fibrosis,raloxifene,43).
medication(pulmonary_fibrosis,azathioprine,36).
medication(pulmonary_fibrosis,bosentan,12).
medication(pulmonary_fibrosis,darifenacin,9).

%abscess of the lung
medication(abscess_of_the_lung,insulin,100).
medication(abscess_of_the_lung,metformin,99).
medication(abscess_of_the_lung,meropenem,13).
medication(abscess_of_the_lung,vancomycin,11).
medication(abscess_of_the_lung,budesonide,8).

%simptomi i dijagnoze

%cough
symptom_diagnose(cough,asthma,17).
symptom_diagnose(cough,abscess_of_the_lung,13).
symptom_diagnose(cough,chronic_obstructive_pulmonary_disease,12).
symptom_diagnose(cough,pulmonary_fibrosis,10).
symptom_diagnose(cough,pulmonary_hypertension,9).
symptom_diagnose(cough,pneumonia,7).
symptom_diagnose(cough,acute_bronchitis,2).

%shortness of breath
symptom_diagnose(shortness_of_breath,pulmonary_hypertension,16).
symptom_diagnose(shortness_of_breath,chronic_obstructive_pulmonary_disease,15).
symptom_diagnose(shortness_of_breath,pulmonary_fibrosis,13).
symptom_diagnose(shortness_of_breath,asthma,13).
symptom_diagnose(shortness_of_breath,abscess_of_the_lung,9).
symptom_diagnose(shortness_of_breath,pneumonia,7).
symptom_diagnose(shortness_of_breath,acute_bronchitis,2).

%nasal congestion
symptom_diagnose(nasal_congestion,chronic_obstructive_pulmonary_disease,9).
symptom_diagnose(nasal_congestion,asthma,6).
symptom_diagnose(nasal_congestion,acute_bronchitis,4).
symptom_diagnose(nasal_congestion,pneumonia,0).
symptom_diagnose(nasal_congestion,abscess_of_the_lung,0).
symptom_diagnose(nasal_congestion,pulmonary_fibrosis,0).
symptom_diagnose(nasal_congestion,pulmonary_hypertension,0).

%fever
symptom_diagnose(fever,pulmonary_fibrosis,8).
symptom_diagnose(fever,pneumonia,5).
symptom_diagnose(fever,chronic_obstructive_pulmonary_disease,4).
symptom_diagnose(fever,asthma,3).
symptom_diagnose(fever,pulmonary_hypertension,3).
symptom_diagnose(fever,acute_bronchitis,3).
symptom_diagnose(fever,abscess_of_the_lung,0).

%sore throat
symptom_diagnose(sore_throat,chronic_obstructive_pulmonary_disease,5).
symptom_diagnose(sore_throat,acute_bronchitis,3).
symptom_diagnose(sore_throat,pneumonia,1).
symptom_diagnose(sore_throat,asthma,0).
symptom_diagnose(sore_throat,pulmonary_hypertension,0).
symptom_diagnose(sore_throat,abscess_of_the_lung,0).
symptom_diagnose(sore_throat,pulmonary_fibrosis,0).

%difficulty breathing
symptom_diagnose(difficulty_breathing,asthma,47).
symptom_diagnose(difficulty_breathing,chronic_obstructive_pulmonary_disease,12).
symptom_diagnose(difficulty_breathing,pulmonary_hypertension,7).
symptom_diagnose(difficulty_breathing,pneumonia,7).
symptom_diagnose(difficulty_breathing,pulmonary_fibrosis,5).
symptom_diagnose(difficulty_breathing,acute_bronchitis,4).
symptom_diagnose(difficulty_breathing,abscess_of_the_lung,1).

%sharp chest pain
symptom_diagnose(sharp_chest_pain,abscess_of_the_lung,13).
symptom_diagnose(sharp_chest_pain,pulmonary_fibrosis,8).
symptom_diagnose(sharp_chest_pain,chronic_obstructive_pulmonary_disease,4).
symptom_diagnose(sharp_chest_pain,pneumonia,3).
symptom_diagnose(sharp_chest_pain,pulmonary_hypertension,3).
symptom_diagnose(sharp_chest_pain,acute_bronchitis,3).
symptom_diagnose(sharp_chest_pain,asthma,2).

%coughing up sputum
symptom_diagnose(coughing_up_sputum,chronic_obstructive_pulmonary_disease,25).
symptom_diagnose(coughing_up_sputum,acute_bronchitis,14).
symptom_diagnose(coughing_up_sputum,asthma,9).
symptom_diagnose(coughing_up_sputum,pneumonia,8).
symptom_diagnose(coughing_up_sputum,pulmonary_fibrosis,4).
symptom_diagnose(coughing_up_sputum,pulmonary_hypertension,0).
symptom_diagnose(coughing_up_sputum,abscess_of_the_lung,0).

%coryza
symptom_diagnose(coryza,asthma,7).
symptom_diagnose(coryza,acute_bronchitis,6).
symptom_diagnose(coryza,pneumonia,3).
symptom_diagnose(coryza,chronic_obstructive_pulmonary_disease,2).
symptom_diagnose(sore_throat,pulmonary_hypertension,0).
symptom_diagnose(sore_throat,abscess_of_the_lung,0).
symptom_diagnose(sore_throat,pulmonary_fibrosis,0).

%chest tightness
symptom_diagnose(chest_tightness,asthma,8).
symptom_diagnose(chest_tightness,chronic_obstructive_pulmonary_disease,6).
symptom_diagnose(chest_tightness,abscess_of_the_lung,4).
symptom_diagnose(chest_tightness,acute_bronchitis,2).
symptom_diagnose(chest_tightness,pneumonia,1).
symptom_diagnose(chest_tightness,pulmonary_hypertension,0).
symptom_diagnose(chest_tightness,pulmonary_fibrosis,0).

%procedure vezane za razlicita pulmoloska oboljenja

%asthma
disease_procedure(asthma,plain_x_ray,100).
disease_procedure(asthma,nebulizer_therapy,94).
disease_procedure(asthma,arterial_blood_gases,46).
disease_procedure(asthma,influenzavirus_antibody_assay,31).

%pneumonia
disease_procedure(pneumonia,radiographic_imaging_procedure,100).
disease_procedure(pneumonia,plain_x_ray,94).
disease_procedure(pneumonia,hematologic_tests,79).
disease_procedure(pneumonia,complete_blood_count,72).
disease_procedure(pneumonia,intravenous_fluid_replacement,32).
disease_procedure(pneumonia,kidney_function_tests,21).
disease_procedure(pneumonia,electrolytes_panel,11).

%chronic obstructive pulmonary disease
disease_procedure(chronic_obstructive_pulmonary_disease,radiographic_imaging_procedure,100).
disease_procedure(chronic_obstructive_pulmonary_disease,plain_x_ray,93).
disease_procedure(chronic_obstructive_pulmonary_disease,hematologic_tests,90).
disease_procedure(chronic_obstructive_pulmonary_disease,complete_blood_count,67).
disease_procedure(chronic_obstructive_pulmonary_disease,glucose_measurement,22).
disease_procedure(chronic_obstructive_pulmonary_disease,kidney_function_tests,15).
disease_procedure(chronic_obstructive_pulmonary_disease,electrolytes_panel,14).

%acute bronchitis
disease_procedure(acute_bronchitis,radiographic_imaging_procedure,100).
disease_procedure(acute_bronchitis,plain_x_ray,98).
disease_procedure(acute_bronchitis,nebulizer_therapy,61).
disease_procedure(acute_bronchitis,kidney_function_tests,57).
disease_procedure(acute_bronchitis,cardiac_enzymes_measurement,41).
disease_procedure(acute_bronchitis,cardiac_monitoring,23).
disease_procedure(acute_bronchitis,blood_culture,8).

%pulmonary hypertension
disease_procedure(pulmonary_hypertension,radiographic_imaging_procedure,100).
disease_procedure(pulmonary_hypertension,hematologic_tests,98).
disease_procedure(pulmonary_hypertension,electrocardiogram,77).
disease_procedure(pulmonary_hypertension,ultrasonography,73).
disease_procedure(pulmonary_hypertension,echocardiography,68).
disease_procedure(pulmonary_hypertension,cardiac_enzymes_measurement,33).

%pulmonary fibrosis
disease_procedure(pulmonary_fibrosis,hematologic_tests,100).
disease_procedure(pulmonary_fibrosis,complete_blood_count,92).
disease_procedure(pulmonary_fibrosis,electrocardiogram,77).
disease_procedure(pulmonary_fibrosis,radiographic_imaging_procedure,71).
disease_procedure(pulmonary_fibrosis,kidney_function_tests,17).
disease_procedure(pulmonary_fibrosis,glucose_measurement,15).

%abscess of the lung
disease_procedure(abscess_of_the_lung,radiographic_imaging_procedure,100).
disease_procedure(abscess_of_the_lung,x_ray_computed_tomography,79).
disease_procedure(abscess_of_the_lung,intravenous_fluid_replacement,72).
disease_procedure(abscess_of_the_lung,plain_x_ray,70).
disease_procedure(abscess_of_the_lung,physical_therapy_exercises,45).


%lista lekova za unetu bolest
medications(B,L) :- findall(A,medication(B,A,V),L).

%lista lekova za unetu bolest sortirana po verovatnoci upotrebe
medications_sorted(B,L) :- findall([V,A],medication(B,A,V),L1),sort(L1,L).

%lista procedura za unetu bolest
procedure_for_disease(B,L) :- findall(P, disease_procedure(B,P,V),L).

%lista bolesti kod kojih uneti lek pomaze
lek_pomaze_za(M,L) :- findall(B,medication(B,M,V),L).

%lista bolesti za odredjene simptome kao i njihova verovatnoca pojavljivanja
verovatnoca_za_dijagnozu(S,L) :- findall([V,B], symptom_diagnose(S,B,V), L1), sort(L1,L).
