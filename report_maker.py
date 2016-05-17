from reportlab.lib.enums import TA_JUSTIFY
from reportlab.lib.pagesizes import letter
from reportlab.platypus import SimpleDocTemplate, Paragraph, Spacer, Image
from reportlab.lib.styles import getSampleStyleSheet, ParagraphStyle
from reportlab.lib.units import inch
import os


def get_files(dir):
    files_list = os.listdir(dir)
    return files_list

def get_subdirectories(name, dir):
    return [name for name in os.listdir(dir)
            if os.path.isdir(os.path.join(dir, name))]


def check_if_directory(name, root):
    all_dirs = get_subdirectories(name, root)
    if name in all_dirs :
        return True 
    else :
        return False


def add_all_images(images_dir):
    pdf_story = []
    images = os.listdir(images_dir)
    for img in images :
        img_dir = os.path.join(images_dir, img)
        story_item = add_image_to_story(img_dir)
        pdf_story.append(story_item)
    return pdf_story




def get_student_info():
    student_name = input("enter your name : ")
    student_section = str(input("enter your section : "))
    report_subject = input("enter the subject of your report : ")
    repor_supervisor = input("enter the supervisor of your report : ")
    return student_name, student_section, report_subject, repor_supervisor


def make_pdf_template(name, margins):
    doc = SimpleDocTemplate("{0}_report.pdf".format(name),pagesize=letter,
                        rightMargin=margins[0],leftMargin=margins[1],
                        topMargin=margins[2],bottomMargin=margins[3])
    styles=getSampleStyleSheet()
    return doc, styles


def add_code_to_story(code_file, codes_dir, styles):
    pdf_story = []
    code_file = os.path.join(codes_dir, code_file)
    with open(code_file, 'r') as f:
        for line in f : 
            code = '<font size=8>{0}</font>'.format(line)
            pdf_story.append(Paragraph(code, styles["Code"]))
    f.close()
    return pdf_story


def add_image_to_story(image):
    img = Image(image, 4*inch, 4*inch)
    return img


def make_pdf_cover(student_name, student_section, report_subject, report_supervisor, styles):
    pdf_story = []
    name = "<font size=18>Name : {0}</font>".format(student_name)
    supervisor = "<font size=18>Supervised by :{0}</font>".format(report_supervisor) 
    section = "<font size=18>Section: {0}</font>".format(student_section)
    report_subject = '<font size=30>{0}</font>'.format(report_subject)
    #type the title
    pdf_story.append(Paragraph(report_subject, styles["Heading1"]))
    pdf_story.append(Spacer(440, 370))
    pdf_story.append(Spacer(100, 100))
    #type the name
    pdf_story.append(Paragraph(name, styles["Justify"]))
    pdf_story.append(Spacer(50, 10))
    #type the section
    pdf_story.append(Paragraph(section, styles["Justify"]))
    pdf_story.append(Spacer(30, 30))
    #type the supervisor name
    pdf_story.append(Paragraph(supervisor, styles["Justify"]))
    pdf_story.append(Spacer(30, 50))
    
    return pdf_story