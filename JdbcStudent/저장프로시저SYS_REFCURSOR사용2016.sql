// JOB�� �����ϴ� ���� ���ν���
CREATE OR REPLACE PROCEDURE delete_job
  (
     p_job_id         jobs.job_id%type
   )
IS
BEGIN
  DELETE FROM JOBS
  WHERE job_id=p_job_id;
END delete_job;
/

// JOB�� ������ ������ �ش� JOB_ID�� ������ JOB_HISTORY ��ϵ� ����
CREATE OR REPLACE TRIGGER delete_job_history_trg 
AFTER DELETE ON jobs
FOR EACH ROW
BEGIN
  delete from job_history
  where job_id= :old.job_id;
END;

-- �������� row�� ����� ������ Stored Procedure ����
-- SYS_REFCURSOR Ÿ���� �Ű������� OUT ���� ���ǵǾ�� �Ѵ�.
CREATE OR REPLACE PROCEDURE get_all_jobs
(
 JOB_CURSOR OUT SYS_REFCURSOR 
) AS 
BEGIN 
  -- ���� ����� OUT ��� �Ű������� ����
  OPEN JOB_CURSOR FOR SELECT * FROM JOBS;
END get_all_jobs;

