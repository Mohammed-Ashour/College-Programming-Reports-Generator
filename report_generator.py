import os
from report_maker import *

def main():
    code_files = get_files("codes")
    code_files.sort()
    image_files = get_files("images")
    image_files.sort()
    
    if len(code_files) == len(image_files) : 
        code_image_list = zip(code_files,image_files)
        st_name, st_section, report_subject, repor_supervisor = get_student_info()

        doc, styles = make_pdf_template(st_name, margins=[72,72,72,72])



        styles=getSampleStyleSheet()
        styles.add(ParagraphStyle(name='Justify', alignment=TA_JUSTIFY))

        story = make_pdf_cover(st_name, st_section, report_subject, repor_supervisor, styles)
        codes_dir = os.path.join(os.curdir, 'codes')
        images_dir = os.path.join(os.curdir, 'images')

        for i in code_image_list :

            code, image = i[0], i[1]
            title ='<font size=18>{0}</font>'.format(code.split('.')[0])
            story.append(Paragraph(title, styles["title"]))
            story.append(Spacer(12, 12))
            cur_story = add_code_to_story(code, codes_dir, styles)
            story.extend(cur_story)
            story.append(Spacer(1, 12))


            cur_image_dir = os.path.join(images_dir, image)
            if check_if_directory(image, images_dir):
                cur_story = add_all_images(cur_image_dir)
                story.extend(cur_story)
                
            else :
                cur_story = add_image_to_story(cur_image_dir)
                story.append(cur_story)
                
            story.append(Spacer(100, 100))

        doc.build(story)
        print("Your Report is Done and ready to be printed :D :D")
    else :
        missing = abs(len(code_files) - len(image_files))
        if len(code_files) > len(image_files): 

            print("there are {0} image files missing !".format(missing))
        else :
            print("there are {0} code files missing !".format(missing))

if __name__ == '__main__':
    main()






