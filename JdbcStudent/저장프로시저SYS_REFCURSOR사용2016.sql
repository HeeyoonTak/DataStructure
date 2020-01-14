// JOB을 삭제하는 저장 프로시저
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

// JOB이 삭제될 때마다 해당 JOB_ID를 가지는 JOB_HISTORY 기록도 삭제
CREATE OR REPLACE TRIGGER delete_job_history_trg 
AFTER DELETE ON jobs
FOR EACH ROW
BEGIN
  delete from job_history
  where job_id= :old.job_id;
END;

-- 여러개의 row를 결과로 보내는 Stored Procedure 정의
-- SYS_REFCURSOR 타입의 매개변수가 OUT 모드로 정의되어야 한다.
CREATE OR REPLACE PROCEDURE get_all_jobs
(
 JOB_CURSOR OUT SYS_REFCURSOR 
) AS 
BEGIN 
  -- 질의 결과를 OUT 모드 매개변수로 전달
  OPEN JOB_CURSOR FOR SELECT * FROM JOBS;
END get_all_jobs;

